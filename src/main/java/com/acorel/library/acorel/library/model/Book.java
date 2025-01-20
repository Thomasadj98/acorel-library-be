package com.acorel.library.acorel.library.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("BOOK")
public class Book {

    @Id
    private Integer id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    private String bookCover;
    @NotEmpty
    private String recommendedByName;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
