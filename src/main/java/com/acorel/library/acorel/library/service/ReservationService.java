package com.acorel.library.acorel.library.service;

import com.acorel.library.acorel.library.model.Book;
import com.acorel.library.acorel.library.model.Reservation;
import com.acorel.library.acorel.library.repository.BookRepository;
import com.acorel.library.acorel.library.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;

    public ReservationService(ReservationRepository reservationRepository, BookRepository bookRepository) {
        this.reservationRepository = reservationRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Reservation> get() {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        for (Reservation reservation : reservations) {
            Optional<Book> book = bookRepository.findById(reservation.getBookId());
            book.ifPresent(reservation::setBook);
        }
        return reservations;
    }

    public Reservation save(Reservation newReservation) {
        Optional<Book> book = bookRepository.findById(newReservation.getBookId());
        book.ifPresent(b -> {
            b.setAvailable(false);
            bookRepository.save(b);
        });
        return reservationRepository.save(newReservation);
    }

    public void delete(Integer id) {
    reservationRepository.findById(id).ifPresent(reservation -> {
        bookRepository.findById(reservation.getBookId()).ifPresent(book -> {
            book.setAvailable(true);
            bookRepository.save(book);
        });
        reservationRepository.deleteById(id);
    });
}
}