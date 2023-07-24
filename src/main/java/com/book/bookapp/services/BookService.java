package com.book.bookapp.services;

import java.util.ArrayList;
import java.util.stream.Collector;

import org.springframework.stereotype.Component;

import com.book.bookapp.entities.Book;

import java.util.*;

@Component
public class BookService {

    /* get all book at a time */
    private static List<Book> list = new ArrayList<>();
    static {

        list.add(new Book(10, "Mathmatics 73000", "By Rakesh yadav"));
        list.add(new Book(11, "English by plinth to paramount", "By neetu mam"));
        list.add(new Book(12, "Hindi", "by Aditya publication"));
        list.add(new Book(13, "Gs By lucent", "Lucent publications"));
    }

    public List<Book> getBooks() {
        return list;
    }

    /* get book by id */
    public Book getBookById(int id) {
        Book b = null;
        for (Book book : list) {
            if (book.getId() == id) {
                b = book;
                break;
            }
        }
        return b;

    }

    public Book addBook(Book book) {
        list.add(book);
        return book;
    }

    /* get one book */
    public Book getBookByTitle(String title) {
        Book b = null;
        for (Book book : list) {
            if (book.getTitle().equals(title)) {
                b = book;
            }
        }
        return b;
    }

    /* deleting the book */

    public Book deleteBook(int id) {

        Book b = null;
        Iterator<Book> itr = list.iterator();

        while (itr.hasNext()) {
            Book book = (Book) itr.next();
            if (book.getId() == id) {
                b = book;
                itr.remove();
            }
        }
        return b;

    }

    // updating the books
    public Book updateBook(Book book, int id) {
        final Book b = list.stream().map(bk -> {
            if (bk.getId() == id) {
                b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
            }
            return b;
        }).collect(Collector.List());
    }
}
