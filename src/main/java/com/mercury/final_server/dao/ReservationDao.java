package com.mercury.final_server.dao;

import com.mercury.final_server.bean.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
}
