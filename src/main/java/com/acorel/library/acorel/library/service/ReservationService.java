package com.acorel.library.acorel.library.service;

import com.acorel.library.acorel.library.model.Reservation;
import com.acorel.library.acorel.library.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Iterable<Reservation> get() {
        return reservationRepository.findAll();
    }

    public Reservation save(Reservation newReservation) {
        return reservationRepository.save(newReservation);
    }

    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }
}