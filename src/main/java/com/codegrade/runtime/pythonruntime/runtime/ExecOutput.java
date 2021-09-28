package com.codegrade.runtime.pythonruntime.runtime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class ExecOutput {

    public enum Status {
        COMPILE,
        RUNTIME,
        TIMEOUT,
        SUCCESS
    }

    private String output;
    private Status status;
}
