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
		
		System.out.printf("ID %s PW %s", user,password);

		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}

}
