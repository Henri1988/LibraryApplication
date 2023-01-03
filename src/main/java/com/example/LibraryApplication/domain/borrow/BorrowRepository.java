package com.example.LibraryApplication.domain.borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    @Query("select b from Borrow b where b.expectedReturnDate < ?1 ")
    List<Borrow> getBorrowsWithReturnDateBefore(LocalDate returnDate);
}