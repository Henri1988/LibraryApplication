package com.example.LibraryApplication.service.library;


import com.example.LibraryApplication.domain.book.BookService;
import com.example.LibraryApplication.domain.borrow.BorrowDto;
import com.example.LibraryApplication.domain.borrow.BorrowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LibraryService {

    @Resource
    private BorrowService borrowService;
    @Resource
    private BookService bookService;


    public void saveBookBorrow(BorrowDto borrowDto) throws Exception {
        borrowService.saveBookBorrow(borrowDto);
        bookService.updateBookQuantityOnLending(borrowDto.getBookId());

    }
}
