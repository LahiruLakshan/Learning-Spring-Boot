package com.example.learningspring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BookResource {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book retrieveBook(@PathVariable int bookId){
        Book book = bookService.findBook(bookId);
        if (book == null){
            throw new BookNotFoundException("Book ID : " + bookId);
        }
        return book;

    }

    @PostMapping("/books")
    public ResponseEntity<Object> createBook(@RequestBody Book book){
        Book saveBook = bookService.addBook(book);

        URI newBookLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{bookId}")
                .buildAndExpand(saveBook.getBookId())
                .toUri();

        return ResponseEntity.created(newBookLocation).build();
    }
}
