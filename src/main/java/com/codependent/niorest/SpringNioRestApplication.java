package com.codependent.niorest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.rx.RxJavaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@EnableCircuitBreaker
@Import(RxJavaAutoConfiguration.class)
@SpringBootApplication
public class SpringNioRestApplication {

	@Bean
	public ThreadPoolTaskExecutor executor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setThreadGroupName("MyThreadGroup");
		executor.setThreadNamePrefix("MyThreadNamePrefix");
		executor.setCorePoolSize(5000);
		return executor;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringNioRestApplication.class, args);
	}
}
