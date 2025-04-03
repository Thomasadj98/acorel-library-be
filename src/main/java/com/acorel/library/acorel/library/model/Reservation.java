package com.acorel.library.acorel.library.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer bookId;
    @Transient
    private Book book;
    @NotNull
    private String reservedByName;
    @Email
    private String reservedByEmail;
    @NotNull
    private String reservedDate;

    public Reservation() {}

    public Reservation(String reservedByName, String reservedByEmail, String reservedDate) {
        this.reservedByName = reservedByName;
        this.reservedByEmail = reservedByEmail;
        this.reservedDate = reservedDate;
    }

    public Integer getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getReservedByName() {
        return reservedByName;
    }

    public void setReservedByName(String reservedByName) {
        this.reservedByName = reservedByName;
    }

    public String getReservedByEmail() {
        return reservedByEmail;
    }

    public void setReservedByEmail(String reservedByEmail) {
        this.reservedByEmail = reservedByEmail;
    }

    public String getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(String reservedDate) {
        this.reservedDate = reservedDate;
    }
}
