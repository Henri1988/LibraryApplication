package com.example.LibraryApplication.service.library;
import com.example.LibraryApplication.domain.book.BookService;
import com.example.LibraryApplication.domain.borrow.Borrow;
import com.example.LibraryApplication.domain.borrow.BorrowDto;
import com.example.LibraryApplication.domain.borrow.BorrowService;
import com.example.LibraryApplication.domain.returnborrow.BorrowReturnService;
import com.example.LibraryApplication.domain.user.contact.Contact;
import com.example.LibraryApplication.domain.user.contact.ContactService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    @Resource
    private BorrowService borrowService;
    @Resource
    private BookService bookService;
    @Resource
    private ContactService contactService;
    @Resource
    private BorrowReturnService returnBorrowService;



    public void saveBookBorrow(BorrowDto borrowDto, Integer userSessionId) throws Exception {
        borrowService.saveBookBorrow(borrowDto);
        bookService.updateBookQuantityOnLending(borrowDto.getBookId());
    }

    public void saveBookBorrowReturn(ReturnBorrowRequest returnBorrowRequest, Integer userSessionId){
        returnBorrowService.saveBookBorrowReturn(returnBorrowRequest);
        bookService.updateBookQuantityOnReturning(returnBorrowRequest);

    }

    public List<LateReturnResponseItem> getReportOfLateBooks(Integer userSessionId) {
        List<LateReturnResponseItem> lateReturnResponse = new ArrayList<>();

        List<Borrow> lateBorrows = borrowService.getLateBorrows();
        for (Borrow borrow: lateBorrows) {
            LateReturnResponseItem item = new LateReturnResponseItem();
            item.setBorrowId(borrow.getId());
            item.setUserId(borrow.getUser().getId());
            item.setBookId(borrow.getBook().getId());
            item.setTitle(borrow.getBook().getTitle());
            item.setDaysOver(ChronoUnit.DAYS.between(borrow.getExpectedReturnDate(), LocalDate.now()));

            Contact contact = contactService.getUserFirstLastNameById(borrow.getUser().getId());
            item.setFirstName(contact.getFirstName());
            item.setLastName(contact.getLastName());

            lateReturnResponse.add(item);
        }

        return lateReturnResponse;
    }
}
