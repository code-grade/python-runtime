package com.codegrade.runtime.pythonruntime.runtime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqRunCode {
    private String source;
    private String input;
    private Double timeLimit;
}
