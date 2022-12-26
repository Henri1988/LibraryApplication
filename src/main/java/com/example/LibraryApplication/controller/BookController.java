package com.example.LibraryApplication.controller;


import com.example.LibraryApplication.domain.book.BookDto;
import com.example.LibraryApplication.domain.book.BookRepository;
import com.example.LibraryApplication.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/by/id")
    @Operation(summary = "Finds book by id")
    public BookDto findBookById (@RequestParam Integer id){
        return bookService.findBookById(id);
    }

}
