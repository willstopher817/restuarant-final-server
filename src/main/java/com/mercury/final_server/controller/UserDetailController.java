package com.mercury.final_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.mercury.final_server.bean.UserDetail;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.UserDetailService;

@RestController
@RequestMapping("/user-profile")
public class UserDetailController {
	
	@Autowired
	UserDetailService userDetailService;

	@GetMapping("/{id}")
	public UserDetail get(@PathVariable("id") int id) {
		return userDetailService.getOneUserDetailDao(id);
	}

	@PostMapping
	public Response postUserDetails(@RequestBody UserDetail userDetail, Authentication authentication) {
		return userDetailService.addUserDetail(userDetail, authentication);
	}
	
	@PutMapping("/{id}")
	public Response putUserDetails(@RequestBody UserDetail userDetail) {
		return userDetailService.updateUserDetail(userDetail);
	}
	
}
