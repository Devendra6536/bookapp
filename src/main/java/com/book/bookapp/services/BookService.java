package com.book.bookapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.bookapp.dao.BookRepository;
import com.book.bookapp.entities.Book;

import java.util.*;

@Component
public class BookService {
    @Autowired
    public BookRepository bookRepository;
    /* get all book at a time */
    // private static List<Book> list = new ArrayList<>();
    /*
     * static {
     * 
     * list.add(new Book(10, "Mathmatics 73000", "By Rakesh yadav"));
     * list.add(new Book(11, "English by plinth to paramount", "By neetu mam"));
     * list.add(new Book(12, "Hindi", "by Aditya publication"));
     * list.add(new Book(13, "Gs By lucent", "Lucent publications"));
     * 
     * }
     */

    public List<Book> getBooks() {
        List<Book> books_list = (List<Book>) this.bookRepository.findAll();
        return books_list;
    }

    /* get book by id */
    public Book getBookById(int id) {
        Book b = null;
        /*
         * for (Book book : list) {
         * if (book.getId() == id) {
         * b = book;
         * break;
         * }
         * }
         * return b;
         */
        b = this.bookRepository.findById(id);
        return b;

    }

    public Book addBook(Book book) {
        // list.add(book);
        Book b = this.bookRepository.save(book);
        return b;
    }

    /* get one book */
    public Book getBookByTitle(String title) {
        Book b = null;
        /*
         * for (Book book : list) {
         * if (book.getTitle().equals(title)) {
         * b = book;
         * }
         * }
         */
        b = this.bookRepository.findByTitle(title);
        return b;
    }

    /* deleting the book */

    public void deleteBook(int id) {

        /*
         * Iterator<Book> itr = list.iterator();
         * while (itr.hasNext()) {
         * Book book = (Book) itr.next();
         * if (book.getId() == id) {
         * itr.remove();
         * }
         * }
         */

        this.bookRepository.deleteById(id);
    }

    public List<Book> delete_book_by_title(String title) {
        List<Book> list = this.bookRepository.deleteAllByTitle(title);
        return list;
    }

    // updating the books
    public void updateBook(Book book, int id) {
        /*
         * list = list.stream().map(bk -> {
         * if (bk.getId() == id) {
         * bk.setAuthor(book.getAuthor());
         * bk.setTitle(book.getTitle());
         * }
         * 
         * return bk;
         * }).collect(Collectors.toList());
         */
        book.setId(id);
        this.bookRepository.save(book);

    }
}
