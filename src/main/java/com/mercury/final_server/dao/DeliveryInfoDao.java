package com.mercury.final_server.dao;

import com.mercury.final_server.bean.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryInfoDao extends JpaRepository<DeliveryInfo, Integer> {

    DeliveryInfo findDeliveryInfoByOrderNum(int orderNum);

    List<DeliveryInfo> findDeliveryInfoByUserId(int id);

}
