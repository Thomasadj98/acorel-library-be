package com.acorel.library.acorel.library.web;

import com.acorel.library.acorel.library.service.BookService;
import com.acorel.library.acorel.library.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public Iterable<Book> get() {
        return bookService.get();
    }

    @GetMapping("/books/{id}")
    public Book get(@PathVariable Integer id) {
        Book book = bookService.get(id);
        if (book == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        return book;
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable Integer id, @RequestBody Book updatedBook) {
        return bookService.update(id, updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.remove(id);
    }

    @PostMapping("/books")
    public Book create(
            @RequestBody Book book
    ) throws IOException {
        return bookService.save(book);
    }
}
