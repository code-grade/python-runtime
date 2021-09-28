package com.codegrade.runtime.pythonruntime.controller;

import com.codegrade.runtime.pythonruntime.runtime.ReqRunCode;
import com.codegrade.runtime.pythonruntime.service.PythonRuntime;
import com.codegrade.runtime.pythonruntime.utils.RBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class PythonController {

    private final PythonRuntime pythonRuntime;

    @PostMapping(path = "/python/run")
    public ResponseEntity<?> test(@RequestBody ReqRunCode runCode) throws IOException, InterruptedException {
        return RBuilder.success()
                .setData(pythonRuntime.run(
                        runCode.getSource(),
                        runCode.getInput(),
                        runCode.getTimeLimit())
                ).compactResponse();
    }
}
