package com.example.LibraryApplication.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@Service
public class MemberService {



//    public MemberDto addMember(MemberDto memberDto) {
//        Member member = memberMapper.toEntity(memberDto);
//        log.info("Adding new member...");
//        memberRepository.save(member);
//        log.info("New member " + member.getFirstName() + " " + member.getLastName() + " with id: "
//                + member.getId() + " added!");
//        return memberMapper.toDto(member);
//    }
//
//
//
//    public MemberDto findByLastName(String name) {
//        log.info("Searching member with name " + name + "...");
//        Optional<Member> member = memberRepository.findByLastName(name);
//        log.info("Member with the name " + name + " found!");
//        return memberMapper.toDto(member.get());
//    }
}
