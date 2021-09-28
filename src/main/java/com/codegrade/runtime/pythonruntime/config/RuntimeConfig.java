package com.codegrade.runtime.pythonruntime.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("runtime")
public class RuntimeConfig {
    private String pythonCmd = "python3";
    private Long maxTimeLimit = 10L;
}
