package com.redpea.singlestore.cloud.app;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class AppContainerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>

{
	@Override
	public void customize(ConfigurableWebServerFactory factory)
	{
		int port=80;
		System.out.printf("setting port to %d..",port);
		factory.setPort(port);
	}
}
