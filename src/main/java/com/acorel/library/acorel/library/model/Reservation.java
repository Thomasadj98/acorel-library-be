package com.acorel.library.acorel.library.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("RESERVATION")
public class Reservation {

    @Id
    private Integer id;
    private Integer bookId;
    @NotEmpty
    private String reservedByName;
    @Email
    private String reservedByEmail;
    @NotEmpty
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

    public Integer getBookId() {
        return bookId;
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
