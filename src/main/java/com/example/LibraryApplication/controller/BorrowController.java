package com.example.LibraryApplication.controller;
import com.example.LibraryApplication.domain.borrow.BorrowDto;
import com.example.LibraryApplication.service.borrow.BorrowResponse;
import com.example.LibraryApplication.service.borrow.BorrowService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Resource
    private BorrowService borrowService;


    @PostMapping("/save")
    @Operation(summary = "Saves book borrow")
    public BorrowResponse saveBookBorrow(@RequestBody BorrowDto borrowDto) throws Exception {
        return borrowService.saveBookBorrow(borrowDto);
    }

}
