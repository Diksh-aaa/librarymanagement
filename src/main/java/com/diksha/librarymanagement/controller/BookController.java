package com.diksha.librarymanagement.controller;

import com.diksha.librarymanagement.model.Book;
import com.diksha.librarymanagement.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        // Service throws BookNotFoundException if not found, handled globally
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        book.setId(null); // ensure INSERT
        return bookService.addBook(book);
    }

    @PutMapping("/{id}/borrow")
    public Book borrowBook(@PathVariable Long id) {
        return bookService.borrowBook(id);
    }

    @PutMapping("/{id}/return")
    public Book returnBook(@PathVariable Long id) {
        return bookService.returnBook(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
