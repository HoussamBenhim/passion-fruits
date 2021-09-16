package com.springframework.passionfruits.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



@Component
@Order(1)
public class CORSFilter implements Filter{
	@Value("${fronturl}")
	private String frontEndURL; 

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		httpresponse.setHeader("Access-Control-Allow-Origin", frontEndURL);
		httpresponse.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
		httpresponse.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, *");
		httpresponse.setHeader("Access-Control-Max-Age", "3600");
		httpresponse.setHeader("Access-Control-Expose-Headers", "*");

		chain.doFilter(request, response); 
		
	}

	
}
