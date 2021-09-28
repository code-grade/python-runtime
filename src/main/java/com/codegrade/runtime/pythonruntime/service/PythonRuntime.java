package com.codegrade.runtime.pythonruntime.service;

import com.codegrade.runtime.pythonruntime.runtime.ExecOutput;
import com.codegrade.runtime.pythonruntime.runtime.Executor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@AllArgsConstructor
public class PythonRuntime {

    private final Executor executor;

    public ExecOutput run(String source, String input, Double timeLimit) throws IOException, InterruptedException {
        return executor.execute(source, input, timeLimit);
    }
}
