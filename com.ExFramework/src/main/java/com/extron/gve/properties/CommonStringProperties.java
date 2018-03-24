package com.extron.gve.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:commonString.${lang}.properties")
public class CommonStringProperties {

	@Value("${label.successfullysaved}")
	public String successfullySavedMessage;

	@Value("${label.incorrectlogin}")
	public String incorrectLoginMessage;

	@Value("${label.loginpageurl}")
	public String loginPageUrl;
	
	@Value("${label.nopassword}")
	public String noPasswordMessage;
	
	@Value("${label.nousername}")
	public String noUsernameMessage;
	
	@Value("${label.addMonitor.success}")
	public String addMonitorSuccess;
}

