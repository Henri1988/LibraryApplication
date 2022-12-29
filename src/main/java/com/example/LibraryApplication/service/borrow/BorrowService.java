package com.example.LibraryApplication.service.borrow;

import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.book.BookMapper;
import com.example.LibraryApplication.domain.borrow.Borrow;
import com.example.LibraryApplication.domain.borrow.BorrowDto;
import com.example.LibraryApplication.domain.borrow.BorrowMapper;
import com.example.LibraryApplication.domain.borrow.BorrowRepository;
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

    @Resource
    private BorrowRepository borrowRepository;


    public BorrowResponse saveBookBorrow(BorrowDto borrowDto) throws Exception {

        Borrow borrow = new Borrow();
        Book book = bookService.getBookById(borrowDto.getBookId());
        User user = userService.getUserById(borrowDto.getUserId());

        borrow.setBook(book);
        borrow.setUser(user);
        borrow.setBorrowedDate(LocalDate.now());

        if (book.getQuantity() < 5) {                 //book.getReleaseTime()<LocalDate.now().minusDays(31)
            borrow.setReturnDate(LocalDate.now().plusDays(7));
        } else {
            borrow.setReturnDate(LocalDate.now().plusDays(28));
        }

        borrowRepository.save(borrow);

  //      if (book.getQuantity() <= 0){
//            throw new Exception();
//        }else{
//            borrow.setBookQuantity(book.getQuantity() -1);
//        }

        BorrowResponse borrowResponse = new BorrowResponse();
        borrowResponse.setBookId(book.getId());
        borrowResponse.setUserId(user.getId());
        borrowResponse.setBorrowedDate(LocalDate.now());
        borrowResponse.setBookTitle(book.getTitle());

        //Todo:add one more condition to if statement. If book releaseTime is newer than 3 months from the time of lending, then
        // the lending period is also 7 days, otherwise its 28 days.
        if (book.getQuantity() < 5) {                 //book.getReleaseTime()<LocalDate.now().minusDays(31)
            borrowResponse.setReturnDate(LocalDate.now().plusDays(7));
        } else {
            borrowResponse.setReturnDate(LocalDate.now().plusDays(28));
        }

        if (book.getQuantity() <= 0){
            throw new Exception();
        }else{
            borrowResponse.setBookQuantity(book.getQuantity() -1);
        }

        return borrowResponse;
    }


//    private void lendOutBook(){
//        bookService.removeOneBook();
//    }

}
