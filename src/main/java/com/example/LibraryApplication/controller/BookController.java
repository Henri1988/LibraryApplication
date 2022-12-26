package com.example.LibraryApplication.controller;


import com.example.LibraryApplication.domain.book.BookDto;
import com.example.LibraryApplication.domain.book.BookRepository;
import com.example.LibraryApplication.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;



    @PostMapping("/add")
    @Operation(summary = "Adds new book")
    public BookDto addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

}
