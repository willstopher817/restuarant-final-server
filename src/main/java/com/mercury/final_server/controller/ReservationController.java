package com.mercury.final_server.controller;

import com.mercury.final_server.bean.Reservation;
import com.mercury.final_server.dao.ReservationDao;
import com.mercury.final_server.http.Response;
import com.mercury.final_server.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationDao reservationDao;

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @PostMapping
    public Response addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping
    public Response updateMenu(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public Response deleteReservation(@PathVariable int id) {
        return reservationService.deleteReservation(id);
    }

}
