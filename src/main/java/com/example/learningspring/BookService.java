package com.example.learningspring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BookService {

    public static List<Book> bookList = new ArrayList<>();

    private static int bookCount = 3;
    static {
        bookList.add(new Book(1,"Harry Potter", new Date()));
        bookList.add(new Book(2,"Titanic", new Date()));
        bookList.add(new Book(3,"Java Beginner", new Date()));
    }

    public List<Book> findAllBooks() {
        return bookList;
    }

    public Book addBook(Book book){
        if (book.getBookId() == null){
            book.setBookId(bookCount++);
        }

        bookList.add(book);
        return book;
    }

    public Book findBook(int id){
        for (Book book:bookList){
            if (book.getBookId() == id){
                return book;
            }
        }

        return null;
    }
}
