package com.example.LibraryApplication.domain.member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Query("select m from Member m where m.id = ?1")
    Member findMemberById(Integer id);
}


