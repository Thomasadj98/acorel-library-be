package com.acorel.library.acorel.library.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    private String bookCover;
    @NotNull
    private String recommendedByName;
    @Size(max = 500)
    private String description;
    private boolean isAvailable;


    public Book() {}

    public Book(String title, String author, String recommendedByName) {
        this.title = title;
        this.author = author;
        this.recommendedByName = recommendedByName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getRecommendedByName() {
        return recommendedByName;
    }

    public void setRecommendedByName(String recommendedByName) {
        this.recommendedByName = recommendedByName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
