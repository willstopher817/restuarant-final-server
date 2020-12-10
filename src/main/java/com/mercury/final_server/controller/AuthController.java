package com.mercury.final_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.final_server.http.AuthenticationSuccessResponse;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@GetMapping("/checklogin")
	public Response checklogin(Authentication authentication) {
		return authService.checklogin(authentication);
	}
}
