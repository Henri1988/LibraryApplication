package com.example.LibraryApplication.service.library;
import com.example.LibraryApplication.domain.borrow.BorrowDto;
import com.example.LibraryApplication.service.authorizer.AuthorizerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Resource
    private LibraryService libraryService;

    @Resource
    private AuthorizerService authorizerService;


    @PostMapping("/save/borrow")
    @Operation(summary = "Saves book borrow")
    public void saveBookBorrow(@RequestBody BorrowDto borrowDto, @RequestParam Integer userSessionId) throws Exception {
        authorizerService.authorizeAsAdmin(userSessionId);
        libraryService.saveBookBorrow(borrowDto, userSessionId);
    }

    @PostMapping("/save/borrow-return")
    @Operation(summary = "Saves book borrow return")
    public void saveBookBorrowReturn(@RequestBody ReturnBorrowRequest returnBorrowRequest, @RequestParam Integer userSessionId) throws Exception {
        authorizerService.authorizeAsAdmin(userSessionId);
        libraryService.saveBookBorrowReturn(returnBorrowRequest, userSessionId);
    }

    @GetMapping("/get/report/delayed/books")
    @Operation(summary = "Gets report of not returned books and their borrowers")
    public List <LateReturnResponseItem>  getReportOfLateBooks(@RequestParam Integer userSessionId) throws Exception {
        authorizerService.authorizeAsAdmin(userSessionId);
        return libraryService.getReportOfLateBooks(userSessionId);
    }
}
