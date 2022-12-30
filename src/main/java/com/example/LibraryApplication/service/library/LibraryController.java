package com.example.LibraryApplication.service.library;
import com.example.LibraryApplication.domain.borrow.BorrowDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update/borrow")
    @Operation(summary = "Returns book borrow")
    public void returnBookBorrow(@RequestBody ReturnBorrowRequest returnBorrowRequest){
        libraryService.returnBookBorrow(returnBorrowRequest);
    }


}
