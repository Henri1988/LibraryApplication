package com.example.LibraryApplication.domain.book;
import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.book.BookDto;
import com.example.LibraryApplication.domain.book.BookMapper;
import com.example.LibraryApplication.domain.book.BookRepository;
import com.example.LibraryApplication.service.library.ReturnBorrowRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookService {

    @Resource
    private BookRepository bookRepository;
    @Resource
    private BookMapper bookMapper;


    public BookResponse addBook(BookDto bookDto) {
        log.info("Adding book...");
        Book book = bookMapper.toEntity(bookDto);
        if (book.getQuantity() < 5 || (book.getReleaseTime().isAfter(LocalDate.now().minusDays(93)))) {
            book.setLendingPeriod(7);
        } else {
            book.setLendingPeriod(28);
        }

        bookRepository.save(book);
        log.info("New book, title: " + book.getTitle() + " with id " + book.getId() + " added!");
        return bookMapper.toResponse(book);
    }

    public BookDto findBookById(Integer id) {
        log.info("Finding book with id " + id + "...");
        Optional<Book> book = bookRepository.findBookById(id);
        log.info("Book with id " + id + " found!");
        return bookMapper.toDto(book.get());
    }

    public BookDto findBookByTitle(String title) {
        log.info("Finding book with title " + title + "...");
        Optional<Book> book = bookRepository.findBookByTitle(title);
        log.info("Book with title " + title + " found!");
        return bookMapper.toDto(book.get());
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDtos(books);
    }

    public List<BookDto> getBooksByGenre(String genre) {
        List<Book> books = bookRepository.findBooksByGenre(genre);
        return bookMapper.toDtos(books);

    }

    public Book getBookById(Integer bookId) {
        return bookRepository.getById(bookId);
    }

    public void updateBookQuantityOnLending(Integer bookId) throws Exception {
        Book book = bookRepository.getBookById(bookId);
        if (book.getQuantity() <= 0) {
            throw new Exception();
        } else {
            book.setQuantity(book.getQuantity() - 1);
        }
        bookRepository.save(book);
    }

    public void updateBookQuantityOnReturning(ReturnBorrowRequest returnBorrowRequest) {
        Book book = bookRepository.getBookById(returnBorrowRequest.getBookId());
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }
}
