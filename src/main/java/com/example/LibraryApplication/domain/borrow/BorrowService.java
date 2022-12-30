package com.example.LibraryApplication.domain.borrow;

import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.domain.book.BookService;
import com.example.LibraryApplication.domain.user.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
public class BorrowService {

    @Resource
    private BookService bookService;
    @Resource
    private UserService userService;
    @Resource
    private BorrowRepository borrowRepository;


    public void saveBookBorrow(BorrowDto borrowDto) throws Exception {

        Borrow borrow = new Borrow();
        Book book = bookService.getBookById(borrowDto.getBookId());
        User user = userService.getUserById(borrowDto.getUserId());

        borrow.setBook(book);
        borrow.setUser(user);
        borrow.setBorrowedDate(LocalDate.now());

        //Todo:add one more condition to if statement. If book releaseTime is newer than 3 months from the time of lending, then
        // the lending period is also 7 days, otherwise its 28 days.
        if (book.getQuantity() < 5) {                 //book.getReleaseTime()<LocalDate.now().minusDays(31)
            borrow.setReturnDate(LocalDate.now().plusDays(7));
        } else {
            borrow.setReturnDate(LocalDate.now().plusDays(28));
        }
        borrowRepository.save(borrow);


    }





}
