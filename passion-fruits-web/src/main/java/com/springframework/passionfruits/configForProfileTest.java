package com.springframework.passionfruits;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
@ConfigurationProperties("database")
@ConstructorBinding
public class configForProfileTest {
	private final String username;
	private final String password;
	private final String jdbcurl;

	public configForProfileTest(String username, String password, String jdbcurl) {
		super();
		this.username = username;
		this.password = password;
		this.jdbcurl = jdbcurl;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getJdbcurl() {
		return jdbcurl;
	}
	
	
}
