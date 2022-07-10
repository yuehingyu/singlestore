package com.redpea.singlestore.cloud.app.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class S2Connection {

	@Value("${spring.datasource.driver}")
	private String driver;

	@Value("${spring.datasource.host}")
	private String host;

	@Value("${spring.datasource.port}")
	private String port;

	@Value("${spring.datasource.database}")
	private String database;


	@Value("#{environment.username}")
	private String user;

	@Value("#{environment.password}")
	private String password;

	@Bean(name = "SqlDataSource")
	@Primary
	public Connection connection() throws SQLException {
		String url = String.format("%s://%s:%s/%s", driver, host, port, database);

		System.out.println(url);
		
		user=System.getenv("environment.username");
		password=System.getenv("environment.password");
		
		System.out.printf("ID %s PW %s", user,password);
		
		String user1="yyu";
		
		String password1="S2usecase2022";
		
		String env_host=System.getenv("spring.datasource.host");
				
		System.out.printf("ID1 %s PW %s env_host %s", user1,password1,env_host);

		Connection connection = DriverManager.getConnection(url, user1, password1);
		// Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}

}
