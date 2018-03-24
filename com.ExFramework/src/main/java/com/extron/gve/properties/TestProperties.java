package com.extron.gve.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test.properties")
public class TestProperties {

	@Value("${lang}")
	public String language;

	@Value("${gve.url}")
	public String url;

	@Value("${gve.username}")
	public String username;

	@Value("${gve.password}")
	public String password;

	@Value("${test.emailSettings.srcEmailAddress}")
	public String tEmailSettingsSrcEmailAddress;

	@Value("${test.emailSettings.emailServer}")
	public String tEmailSettingsEmailServer;

	@Value("${test.emailSettings.smtpUserName}")
	public String tEmailSettingsSmtpUsername;

	@Value("${test.emailSettings.smtpPassword}")
	public String tEmailSettingsSmtpPassword;

	@Value("${test.emailTemplate.templateName}")
	public String tEmailTemplateName;

	@Value("${test.emailTemplate.templateDescription}")
	public String tEmailTemplateDescription;

	@Value("${test.emailTemplate.templateSubject}")
	public String tEmailTemplateSubject;

	@Value("${test.emailTemplate.templateBody}")
	public String tEmailTemplateBody;
	
	@Value("${test.newMonitor.monitorName}")
	public String monitorName;
	
	@Value("${test.newMonitor.monitorDescription}")
	public String monitorDescription;
	
	@Value("${test.newMonitor.deviceType}")
	public String deviceType;
	
	@Value("${test.newMonitor.monitorType}")
	public String monitorType;
	
	@Value("${test.newMonitor.comparisonType}")
	public String comparisonType;

}

