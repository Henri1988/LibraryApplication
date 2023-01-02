package com.example.LibraryApplication.domain.borrow;
import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.returnborrow.ReturnBorrow;
import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.domain.book.BookService;
import com.example.LibraryApplication.domain.user.user.UserService;
import com.example.LibraryApplication.service.library.ReturnBorrowRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Slf4j
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

        log.info("Creating new book borrow...");
        borrow.setBook(book);
        borrow.setUser(user);
        borrow.setBorrowedDate(LocalDate.now());

        if (book.getQuantity() < 5 || (book.getReleaseTime().isAfter(LocalDate.now().minusDays(93)))) {
            borrow.setReturnDate(LocalDate.now().plusDays(7));
        } else {
            borrow.setReturnDate(LocalDate.now().plusDays(28));
        }
        borrowRepository.save(borrow);
        log.info("New book borrow with id: " + borrow.getId() + " is saved!");
    }


    public Borrow getBorrowById(Integer borrowId) {
        return borrowRepository.getById(borrowId);

    }

    public List<Borrow> getLateBorrows() {
        return borrowRepository.getBorrowsWithReturnDateBefore(LocalDate.now());
    }
}
