package com.codegrade.runtime.pythonruntime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@EnableAsync
@RequiredArgsConstructor
@Getter @Setter
@SpringBootApplication
@EnableConfigurationProperties
public class PythonRuntimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PythonRuntimeApplication.class, args);
	}

}
