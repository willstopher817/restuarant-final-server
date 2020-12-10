package com.mercury.final_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.final_server.bean.User;
import com.mercury.final_server.bean.UserDetail;
import com.mercury.final_server.dao.UserDao;
import com.mercury.final_server.dao.UserDetailDao;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.http.UserDetailResponse;


@Service
public class UserDetailService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserDetailDao userDetailDao;

	public UserDetail getOneUserDetailDao(int id) {
		return userDetailDao.findById(id).orElse(new UserDetail());
	}

	public Response addUserDetail(UserDetail userDetail, Authentication authentication) {
		User user = userDao.findByUsername(authentication.getName());
		userDetail.setUser(user);
		return new UserDetailResponse(true, userDetailDao.save(userDetail));
	}
	
	public Response updateUserDetail(UserDetail userDetail) {
		UserDetail ud = userDetailDao.findById(userDetail.getId()).get();
		userDetail.setUser(ud.getUser());
		ud = userDetail;
		userDetailDao.save(ud);
		return new Response(true);
	}
}
