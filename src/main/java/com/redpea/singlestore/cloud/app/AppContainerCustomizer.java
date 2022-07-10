package com.redpea.singlestore.cloud.app;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class AppContainerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>

{
	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		System.out.println("setting port to 8080..");
		factory.setPort(8080);
	}
}
