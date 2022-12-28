package com.example.LibraryApplication.controller;
import com.example.LibraryApplication.service.borrow.BorrowService;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class BorrowController {

    @Resource
    private BorrowService borrowService;

}
