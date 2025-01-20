package com.acorel.library.acorel.library.web;

import com.acorel.library.acorel.library.model.Reservation;
import com.acorel.library.acorel.library.service.ReservationService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public Iterable<Reservation> get() {
        return reservationService.get();
    }

    @PostMapping("/reservations")
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @DeleteMapping("/reservations/{id}")
    public void delete(@PathVariable Integer id) {
        reservationService.delete(id);
    }
}
