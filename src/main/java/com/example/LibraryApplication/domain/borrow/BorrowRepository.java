package com.example.LibraryApplication.domain.borrow;

import com.example.LibraryApplication.domain.returnborrow.ReturnBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    @Query("select b from Borrow b where b.returnDate < ?1 ")
    List<Borrow> getBorrowsWithReturnDateBefore(LocalDate returnDate);
}