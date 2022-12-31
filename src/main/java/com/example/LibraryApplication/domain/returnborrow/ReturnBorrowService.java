package com.example.LibraryApplication.domain.returnborrow;
import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.book.BookService;
import com.example.LibraryApplication.domain.borrow.Borrow;
import com.example.LibraryApplication.domain.borrow.BorrowService;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.domain.user.user.UserService;
import com.example.LibraryApplication.service.library.ReturnBorrowRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDate;

@Slf4j
@Service
public class ReturnBorrowService {

    @Resource
    private BookService bookService;
    @Resource
    private UserService userService;
    @Resource
    private BorrowService borrowService;
    @Resource
    private ReturnBorrowRepository returnBorrowRepository;


    public void saveBookBorrowReturn(ReturnBorrowRequest returnBorrowRequest) {
        ReturnBorrow returnBorrow = new ReturnBorrow();

        log.info("Creating new book borrow return...");
        Book book = bookService.getBookById(returnBorrowRequest.getBookId());
        User user = userService.getUserById(returnBorrowRequest.getUserId());
        Borrow borrow = borrowService.getBorrowById(returnBorrowRequest.getBorrowId());

        returnBorrow.setBook(book);
        returnBorrow.setUser(user);
        returnBorrow.setBorrow(borrow);
        returnBorrow.setReturnedDate(LocalDate.now());

        returnBorrowRepository.save(returnBorrow);
        log.info(" Book borrow return with id " + returnBorrow.getId() + " is saved!");
    }
}
