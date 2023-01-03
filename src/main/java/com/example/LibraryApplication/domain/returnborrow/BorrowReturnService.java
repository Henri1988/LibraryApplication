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
public class BorrowReturnService {
    @Resource
    private BookService bookService;
    @Resource
    private UserService userService;
    @Resource
    private BorrowService borrowService;
    @Resource
    private BorrowReturnRepository borrowReturnRepository;


    public void saveBookBorrowReturn(ReturnBorrowRequest returnBorrowRequest) {
        BorrowReturn borrowReturn = new BorrowReturn();

        log.info("Creating new book borrow return...");
        Book book = bookService.getBookById(returnBorrowRequest.getBookId());
        User user = userService.getUserById(returnBorrowRequest.getUserId());
        Borrow borrow = borrowService.getBorrowById(returnBorrowRequest.getBorrowId());

        borrowReturn.setBook(book);
        borrowReturn.setUser(user);
        borrowReturn.setBorrow(borrow);
        borrowReturn.setReturnedDate(LocalDate.now());

        borrowReturnRepository.save(borrowReturn);
        log.info(" Book borrow return with id " + borrowReturn.getId() + " is saved!");
    }
}
