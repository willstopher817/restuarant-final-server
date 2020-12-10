package com.mercury.final_server.dao;

import com.mercury.final_server.bean.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDao extends JpaRepository<Purchase, Long> {
}
