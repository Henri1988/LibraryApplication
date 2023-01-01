package com.example.LibraryApplication.service.library;
import com.example.LibraryApplication.domain.book.BookService;
import com.example.LibraryApplication.domain.borrow.BorrowDto;
import com.example.LibraryApplication.domain.borrow.BorrowService;
import com.example.LibraryApplication.domain.returnborrow.ReturnBorrowService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class LibraryService {
    @Resource
    private BorrowService borrowService;
    @Resource
    private BookService bookService;

    @Resource
    private ReturnBorrowService returnBorrowService;



    public void saveBookBorrow(BorrowDto borrowDto) throws Exception {
        borrowService.saveBookBorrow(borrowDto);
        bookService.updateBookQuantityOnLending(borrowDto.getBookId());
    }

    public void saveBookBorrowReturn(ReturnBorrowRequest returnBorrowRequest){
        returnBorrowService.saveBookBorrowReturn(returnBorrowRequest);
        bookService.updateBookQuantityOnReturning(returnBorrowRequest);

    }

    public List<LateReturnResponse> getReportOfLateBooks() {
        return null;
    }
}
