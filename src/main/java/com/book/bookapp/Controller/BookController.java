package com.book.bookapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        List<Book> books = this.bookService.getBooks();
        System.out.println(books);
        return books;
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id) {

        return this.bookService.getBookById(id);
    }

    @GetMapping("/home")
    public String home() {
        return "Home page controller";
    }

    @PostMapping("/add_book")
    public Book addNewBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        System.out.println("this is the added book " + b);
        return b;
    }

    @GetMapping("/book_by_title/{title}")
    public Book getOneBookByTitle(@PathVariable("title") String title) {
        Book b = this.bookService.getBookByTitle(title);
        return b;
    }

    @DeleteMapping("/delete_books/{id}")
    public Book deleteBook(@PathVariable("id") int id) {
        Book b = this.bookService.deleteBook(id);
        return b;
    }
}
