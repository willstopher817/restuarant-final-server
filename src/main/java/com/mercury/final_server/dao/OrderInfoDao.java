package com.mercury.final_server.dao;

import com.mercury.final_server.bean.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderInfoDao extends JpaRepository<OrderInfo, Integer> {

    List<OrderInfo> findByUserId(int userId);

    List<OrderInfo> findByOrderNum(int orderNum);

}
