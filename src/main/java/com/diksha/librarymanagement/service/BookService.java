package com.diksha.librarymanagement.service;

import com.diksha.librarymanagement.exception.BookNotFoundException;
import com.diksha.librarymanagement.exception.InvalidOperationException;
import com.diksha.librarymanagement.model.Book;
import com.diksha.librarymanagement.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Fetch all books
     */
    public List<Book> getAllBooks() {
        log.debug("Fetching all books from library");
        return bookRepository.findAll();
    }

    /**
     * Fetch book by ID
     */
    public Book getBookById(Long id) {
        log.debug("Fetching book with id {}", id);
        return bookRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Book not found with id {}", id);
                    return new BookNotFoundException(id);
                });
    }

    /**
     * Add a new book
     */
    public Book addBook(Book book) {
        book.setId(null); // Ensure INSERT instead of UPDATE
        log.info("Adding new book: {} by {}", book.getTitle(), book.getAuthor());
        return bookRepository.save(book);
    }

    /**
     * Borrow a book
     */
    public Book borrowBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Attempt to borrow non-existent book with id {}", id);
                    return new BookNotFoundException(id);
                });

        if (book.isBorrowed()) {
            log.error("Attempt to borrow already borrowed book with id {}", id);
            throw new InvalidOperationException("Book is already borrowed");
        }

        book.setBorrowed(true);
        log.info("Book borrowed successfully: {}", book.getTitle());
        return bookRepository.save(book);
    }

    /**
     * Return a book
     */
    public Book returnBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Attempt to return non-existent book with id {}", id);
                    return new BookNotFoundException(id);
                });

        if (!book.isBorrowed()) {
            log.error("Attempt to return book that was not borrowed, id {}", id);
            throw new InvalidOperationException("Book was not borrowed");
        }

        book.setBorrowed(false);
        log.info("Book returned successfully: {}", book.getTitle());
        return bookRepository.save(book);
    }

    /**
     * Delete a book
     */
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            log.error("Attempt to delete non-existent book with id {}", id);
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
        log.info("Book deleted successfully with id {}", id);
    }
}
