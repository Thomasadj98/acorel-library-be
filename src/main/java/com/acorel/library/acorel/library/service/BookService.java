package com.acorel.library.acorel.library.service;

import com.acorel.library.acorel.library.model.Book;
import com.acorel.library.acorel.library.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> get() {
        return bookRepository.findAll();
    }

    public Book get(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book update(Integer id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setBookCover(updatedBook.getBookCover());
            book.setRecommendedByName(updatedBook.getRecommendedByName());
            book.setDescription(updatedBook.getDescription());
            return bookRepository.save(book);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    public void remove(Integer id) {
        bookRepository.deleteById(id);
    }

    public Book save(Book newBook) {
        Book book = new Book(newBook.getTitle(), newBook.getAuthor(), newBook.getRecommendedByName());
        if (newBook.getBookCover().isEmpty()) {
            book.setBookCover("https://via.placeholder.com/150");
        } else {
            book.setBookCover(newBook.getBookCover());
        }
        if (newBook.getDescription().isEmpty()) {
            book.setDescription("No description available");
        } else {
            book.setDescription(newBook.getDescription());
        }
        book.setAvailable(true);
        bookRepository.save(book);
        return book;
    }
}
