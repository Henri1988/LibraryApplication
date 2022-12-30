package com.example.LibraryApplication.controller;


import com.example.LibraryApplication.domain.borrow.BorrowDto;
import com.example.LibraryApplication.service.library.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Resource
    private LibraryService libraryService;


    @PostMapping("/save/borrow")
    @Operation(summary = "Saves book borrow")
    public void saveBookBorrow(@RequestBody BorrowDto borrowDto) throws Exception {
        libraryService.saveBookBorrow(borrowDto);
    }

}
