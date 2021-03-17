package com.spring.thread;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

	@Bean(name = "threadPoolTaskExecutor")
	@Qualifier
	public Executor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(20);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("TEST_");
		executor.initialize();
		return executor;

	}
	
	@Bean(name = "myexecutor")
	@Qualifier
	public ThreadPoolTaskExecutor myexecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(20);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("TEST_");
		executor.initialize();
		return executor;

	}
	
	@Bean(name = "tester")
	@Qualifier
	public ThreadPoolTaskExecutor tester() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("TEST_");
		executor.initialize();
		return executor;

	}

	@Bean(name = "secondThread")
	@Qualifier
	public Executor createSecondThreadPool() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(100);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("TEST2_");
		executor.initialize();
		return executor;
	}

}