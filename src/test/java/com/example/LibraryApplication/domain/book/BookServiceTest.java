package com.example.LibraryApplication.domain.book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.Resource;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @Test
    void addBook() {
        //given
        BookDto bookDtoIn = new BookDto();
        bookDtoIn.setTitle("Some book");
        bookDtoIn.setAuthor("Some author");
        bookDtoIn.setGenre("Some genre");
        bookDtoIn.setLocation("Some location");
        bookDtoIn.setReleaseTime(LocalDate.now());
        bookDtoIn.setQuantity(6);

        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(1);
        bookResponse.setTitle("Some book");
        bookResponse.setAuthor("Some author");
        bookResponse.setGenre("Some genre");
        bookResponse.setLocation("Some location");
        bookResponse.setReleaseTime(LocalDate.now());
        bookResponse.setLendingPeriod(7);
        bookResponse.setQuantity(6);

        Book book = new Book();
        book.setId(1);
        book.setTitle("Some book");
        book.setAuthor("Some author");
        book.setGenre("Some genre");
        book.setLocation("Some location");
        book.setReleaseTime(LocalDate.now());
        book.setQuantity(6);

        when(bookMapper.toEntity(bookDtoIn)).thenReturn(book);
        when(bookMapper.toResponse(book)).thenReturn(bookResponse);

        //when
        BookResponse result = bookService.addBook(bookDtoIn);

        //then
        assertEquals(result.getId(),1);
        assertEquals(result.getQuantity(),6);

    }
}