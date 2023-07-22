package com.book.bookapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookapp.entities.Book;
import com.book.bookapp.services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllbooksBooks() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("Java Spring boot complete guide");
        book.setAuthor("Rakesh yadav");
        List<Book> books = bookService.getBooks();
        System.out.println(books);
        return books;
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id) {

        return bookService.getBookById(id);
    }

    @GetMapping("/home")
    public String home() {
        return "Home page controller";
    }
}
