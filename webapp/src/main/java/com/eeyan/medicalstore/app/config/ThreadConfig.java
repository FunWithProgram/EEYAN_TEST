package com.eeyan.medicalstore.app.config;


import java.util.concurrent.Executor;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Named
public class ThreadConfig {
	
	@Value("${thread.core.size}")
	private int threadCoreSize;
	@Value("${thread.max.size}")
	private int threadMaxSize;
	@Value("${thread.queue.size}")
	private int threadQueueSize;

	@Bean
	public Executor getExecutor(){
		ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(threadCoreSize);
		taskExecutor.setMaxPoolSize(threadMaxSize);
		taskExecutor.setQueueCapacity(threadQueueSize);
		taskExecutor.setThreadNamePrefix("Bucketizer-Thread");
		taskExecutor.initialize();
		return taskExecutor;		
	}
}