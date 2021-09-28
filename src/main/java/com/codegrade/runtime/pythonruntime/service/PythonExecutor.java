package com.codegrade.runtime.pythonruntime.service;

import com.codegrade.runtime.pythonruntime.runtime.ExecOutput;
import com.codegrade.runtime.pythonruntime.runtime.Executor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PythonExecutor implements Executor {

    @Override
    public ExecOutput execute(String source, String input, Double timeLimit) throws IOException, InterruptedException {
        var commands = List.of(
                "timeout", "-s", "SIGKILL", "-k", "1s", timeLimit.toString(),
                "python", "-c", source
        );
        StringBuilder output = new StringBuilder();

        // Start process
        ProcessBuilder procBuilder = new ProcessBuilder(commands);
        Process proc = procBuilder.start();

        // Write input data
        BufferedWriter stdOutput = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));
        stdOutput.write(input);
        stdOutput.flush();
        stdOutput.close();

        // Waiting for result
        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        String s = null;
        while ((s = stdInput.readLine()) != null) output.append(s).append('\n');
        while ((s = stdError.readLine()) != null) output.append(s).append('\n');

        // Wait before force kill
        proc.waitFor(10, TimeUnit.SECONDS);

        // Generate output status
        ExecOutput.Status outputStatus;
        switch (proc.exitValue()) {
            case 0:
               outputStatus = ExecOutput.Status.SUCCESS;
               break;
            case 137:
                outputStatus = ExecOutput.Status.TIMEOUT;
                break;
            default:
                outputStatus = ExecOutput.Status.RUNTIME;
        }

        return ExecOutput.builder()
                .output(output.toString())
                .status(outputStatus)
                .build();
    }
}
