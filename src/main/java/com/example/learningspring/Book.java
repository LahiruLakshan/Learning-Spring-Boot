package com.example.learningspring;

import java.util.Date;

public class Book {

    private Integer bookId;
    private String bookName;
    private Date publishedDate;

    public Book(Integer bookId, String bookName, Date publishedDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publishedDate = publishedDate;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
