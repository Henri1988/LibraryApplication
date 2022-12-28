package com.example.LibraryApplication.service.borrow;

import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.book.BookMapper;
import com.example.LibraryApplication.domain.borrow.Borrow;
import com.example.LibraryApplication.domain.borrow.BorrowDto;
import com.example.LibraryApplication.domain.borrow.BorrowMapper;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.service.book.BookService;
import com.example.LibraryApplication.service.user.UserService;
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
    private BorrowMapper borrowMapper;


    public BorrowResponse saveBookBorrow(BorrowDto borrowDto) {

        BorrowResponse borrowResponse = new BorrowResponse();
        Book book = bookService.getBookById(borrowDto.getBookId());
        User user = userService.getUserById(borrowDto.getUserId());

        borrowResponse.setBookId(book.getId());
        borrowResponse.setUserId(user.getId());
        borrowResponse.setBorrowedDate(LocalDate.now());

        //Todo:add one more condition to if statement. If book releaseTime is newer than 3 months from the time of lending, then
        // the lending period is also 7 days, otherwise its 28 days.
        if(book.getQuantity() < 5 ){                 //book.getReleaseTime()<LocalDate.now().minusDays(31)
            borrowResponse.setReturnDate(LocalDate.now().plusDays(7));
        }else{
            borrowResponse.setReturnDate(LocalDate.now().plusDays(28));
        }

        borrowResponse.setBookQuantity(book.getQuantity());



        borrowResponse.setBookReleaseTime(book.getReleaseTime());


       /* private String bookTitle;
        private String bookAuthor;
        private LocalDate bookReleaseTime;
        private String bookGenre;
        private Integer bookLendingPeriod;
        private String bookLocation;
        private Integer bookQuantity;
        private LocalDate borrowedDate;
        private LocalDate returnDate;*/




    }


//    public void saveBookOrder(Collection<Long> selectedBookIds, User user) {
//        for (Long bookId : selectedBookIds) {
//            Book book = bookRepo.findById(bookId).get();
//            book.setReturnDate(LocalDate.now().plusDays(20));
//            book.setStartReservationDate(null);
//            book.setEndReservationDate(null);
//            book.setReservedByUser(null);
//            book.setReadyForPickup(false);
//            book.setTheUser(user);
//            bookRepo.save(book);
//            usRepo.save(user);
//        }
//    }
}
