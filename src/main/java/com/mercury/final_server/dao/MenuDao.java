package com.mercury.final_server.dao;


import com.mercury.final_server.bean.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDao extends JpaRepository<Menu, Long> {
}
