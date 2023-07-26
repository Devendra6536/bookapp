package com.book.bookapp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookapp.entities.Book;
import com.book.bookapp.services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    String ANSI_RESET = "\u001B[0m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_YELLOW = "\u001B[33m";

    @GetMapping("/")
    public String entryPointController() {
        return "bye bye engineers";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllbooksBooks() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("Java Spring boot complete guide");
        book.setAuthor("Rakesh yadav");
        List<Book> books = this.bookService.getBooks();

        if (books.size() <= 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.err.println("\t\t\t\t***********All books**********************");
        System.out.println(ANSI_GREEN + books + ANSI_RESET);
        return ResponseEntity.of(Optional.of(books));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {

        Book book = this.bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));

    }

    @GetMapping("/home")
    public String home() {
        return "Home page controller";
    }

    @PostMapping("/add_book")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            System.out.println(ANSI_GREEN + " Book is added successfully" + b + ANSI_RESET);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/book_by_title/{title}")
    public Book getOneBookByTitle(@PathVariable("title") String title) {
        System.out.println(ANSI_GREEN + "data is fetched successfully" + ANSI_RESET);
        Book b = this.bookService.getBookByTitle(title);
        return b;
    }

    @DeleteMapping("/delete_books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {

        try {
            this.bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update_books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        try {

            System.out.println(ANSI_YELLOW + "The book is updated" + ANSI_RESET);
            this.bookService.updateBook(book, id);
            return ResponseEntity.of(Optional.of(book));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
