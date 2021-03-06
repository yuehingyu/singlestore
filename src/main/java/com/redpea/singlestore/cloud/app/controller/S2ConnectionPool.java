package com.redpea.singlestore.cloud.app.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.singlestore.jdbc.SingleStorePoolDataSource;

@Configuration
public class S2ConnectionPool {

	@Value("${spring.datasource.singlestore.driver}")
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

	@Value("${spring.datasource.pool.size}")
	private int size;

	@Value("${spring.datasource.connectTimeout}")
	private int timeout;

	@Bean(name = "S2Pool")
	public SingleStorePoolDataSource pool() throws SQLException {

		getEnvironmentInfo();
		
		String url = String.format("%s://%s:%s/%s?user=%s&password=%s&maxPoolSize=%d&connectTimeout=%d", driver, host,
				port, database, user, password, size, timeout);

		System.out.println("S2ConnectionPool " + url);

		SingleStorePoolDataSource pool = new SingleStorePoolDataSource(url);

		return pool;
	}

	public void getEnvironmentInfo() {

		host = System.getenv("spring.datasource.host");
		database = System.getenv("spring.datasource.database");
		port = System.getenv("spring.datasource.port");
		driver = System.getenv("spring.datasource.singlestore.driver");
		user = System.getenv("environment.username");
		password = System.getenv("environment.password");
		size=Integer.parseInt(System.getenv("spring.datasource.pool.size"));
		timeout=Integer.parseInt(System.getenv("spring.datasource.connectTimeout"));
		

	}

}
