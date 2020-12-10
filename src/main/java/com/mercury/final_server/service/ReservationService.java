package com.mercury.final_server.service;

import com.mercury.final_server.bean.Reservation;
import com.mercury.final_server.dao.ReservationDao;
import com.mercury.final_server.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationDao reservationDao;

    public List<Reservation> getAllReservations() {
        return reservationDao.findAll();
    }

    public Response addReservation(Reservation reservation) {
        reservationDao.save(reservation);
        return new Response(true);
    }

    // cache moved to dao for updating purpose
    public Response updateReservation(Reservation reservation) {
        try {
            Reservation r = reservationDao.getOne(reservation.getId());
            r.setName(reservation.getName());
            r.setName(reservation.getName());
            r.setPhone(reservation.getPhone());
            r.setPeople(reservation.getPeople());
            r.setTime(reservation.getTime());
            r.setSpot(reservation.getSpot());
            reservationDao.save(r);
            return new Response(true);
        } catch (Exception e) {
            return new Response(false);
        }
    }

    public Response deleteReservation(long id) {
        try {
            reservationDao.deleteById(id);
            return new Response(true);
        } catch (Exception e) {
            return new Response(false);
        }
    }

}
