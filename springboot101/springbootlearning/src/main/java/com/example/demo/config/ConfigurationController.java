package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * There are three ways to get configurations:
 * <p>
 * 1:Fields,2:(configuration) Bean from
 * application.yml/properties,3:User-defined files like "test.yml/properties"
 * How to use spring-boot controller.
 * 
 * @author anqi.xiong
 *
 */

@RestController
@RequestMapping("/config")
@EnableConfigurationProperties({ ConfigurationBeanFromApplication.class, ConfigurationBeanFromUserDefined.class })
/**
 * 2.how to automatically get configuration.
 */
public class ConfigurationController {

	// 1.how to get the configuration in yml/properties files respectively.
	@Value("${performance.threadPoolSize}")
	private String threadPoolSize;

	@Value("${performance.timeOut}")
	private int timeOut;


	@RequestMapping("/fromFields")
	public String getField() {
		return "This is from fields:threadPoolSize= " + threadPoolSize + ",timeOut=" + timeOut;
	}


	@Autowired
	@Qualifier("fromApplication")
	ConfigurationBeanFromApplication fromApplication;
	
	@RequestMapping("/fromApp")
	public String getApplicationConfiguration() {
		return "This is from automatically inject bean:threadPoolSize=" + fromApplication.getThreadPoolSize()
				+ ",timeOut=" + fromApplication.getTimeOut();
	}


	@Autowired
	@Qualifier("fromUserDefined")
	ConfigurationBeanFromUserDefined fromUserDefined;
	
	@RequestMapping("/fromUser")
	public String getUserDefinedConfiguration() {
		return "This is from user-defined files:userName=" + fromUserDefined.getUserName() + ",passwd:"
				+ fromUserDefined.getPasswd();
	}

}
