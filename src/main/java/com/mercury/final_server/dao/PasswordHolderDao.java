package com.mercury.final_server.dao;

import com.mercury.final_server.bean.PasswordHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordHolderDao extends JpaRepository<PasswordHolder, Long> {
}
