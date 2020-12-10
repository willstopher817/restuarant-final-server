package com.mercury.final_server.dao;

import com.mercury.final_server.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {

    List<Order> findById(int id);

}
