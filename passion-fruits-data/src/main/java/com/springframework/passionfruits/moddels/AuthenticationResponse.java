package com.springframework.passionfruits.moddels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
public class AuthenticationResponse {

	private final String jwt;

}
