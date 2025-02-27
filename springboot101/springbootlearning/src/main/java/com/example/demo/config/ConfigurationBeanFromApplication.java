package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "performance") //1.If the configuration has a prefix,we have to write down this.
@Component("fromApplication") // 2. Component is unnecessary.
public class ConfigurationBeanFromApplication {
	
	private int threadPoolSize;
	
	private int timeOut;

	public int getThreadPoolSize() {
		return threadPoolSize;
	}

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
}
