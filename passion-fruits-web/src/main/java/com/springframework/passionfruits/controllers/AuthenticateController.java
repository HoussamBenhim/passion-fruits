package com.springframework.passionfruits.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.passionfruits.moddels.AuthenticationRequest;
import com.springframework.passionfruits.moddels.AuthenticationResponse;
import com.springframework.passionfruits.security.services.UserDetailsServiceImpl;
import com.springframework.passionfruits.security.util.JwtUtil;

@RestController
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManger;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticatoinRequest)
			throws Exception {
		try {
			System.out.println(authenticatoinRequest.getUsername());
			System.out.println(authenticatoinRequest.getPassword());

			authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(
					authenticatoinRequest.getUsername(), authenticatoinRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or passwor!!");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticatoinRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
