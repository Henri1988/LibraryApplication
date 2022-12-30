package com.example.LibraryApplication.service.library;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.time.LocalDate;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnBorrowRequest {
    private Integer userId;
    private Integer bookId;
    private LocalDate returnedDate;
}
