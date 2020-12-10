package com.mercury.final_server.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.final_server.bean.UserDetail;

public interface UserDetailDao extends JpaRepository<UserDetail, Integer> {

}
