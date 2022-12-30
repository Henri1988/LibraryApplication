package com.example.LibraryApplication.domain.book;
import com.example.LibraryApplication.domain.book.BookDto;
import com.example.LibraryApplication.domain.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;


    @PostMapping("/add")
    @Operation(summary = "Adds new book")
    public BookDto addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

    @GetMapping("/by/id")
    @Operation(summary = "Finds book by id")
    public BookDto findBookById (@RequestParam Integer id){
        return bookService.findBookById(id);
    }

    @GetMapping("/by/title")
    @Operation(summary = "Finds book by title")
    public BookDto findBookByTitle (@RequestParam String title){
        return bookService.findBookByTitle(title);
    }

    @GetMapping("/find/all")
    @Operation(summary = "Finds all books")
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/find/by/genre")
    @Operation(summary = "Finds books by genre")
    public List<BookDto>getBooksByGenre(@RequestParam String genre){
        return bookService.getBooksByGenre(genre);
    }



}
