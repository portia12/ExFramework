package com.extron.gve.framwork.publicObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.extron.gve.properties.TestProperties;

@Component
public class TestUserFactory {
	@Autowired
	private ApplicationContext context;

	public TestUserFactory(ApplicationContext context) {
		this.context = context;
	}

	private NameGenerator getNameGenerator() {
		return context.getBean(NameGenerator.class);
	}

	private PhoneNumberGenerator getPhoneNumberGenerator() {
		return context.getBean(PhoneNumberGenerator.class);
	}

	private TestProperties getTestProperties() {
		return context.getBean(TestProperties.class);
	}

	public TestUser getTestUser() {
		TestProperties tp = getTestProperties();
		NameGenerator ng = getNameGenerator();
		PhoneNumberGenerator png = getPhoneNumberGenerator();

		return new TestUser(tp, ng, png);
	}
}

