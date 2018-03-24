package com.extron.gve.spring;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.extron.gve.properties.TestProperties;

@Configuration
@ComponentScan(basePackages = "com.extron.gve")
public class SpringConfiguration {

	@Autowired
	TestProperties testProperties;

	@Bean
	WebDriver driver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(testProperties.url);
		return driver;
	}

	@Bean
	Random random() {
		return new Random();
	}
}


