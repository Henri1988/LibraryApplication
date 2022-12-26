package com.example.LibraryApplication.service;
import com.example.LibraryApplication.domain.member.Member;
import com.example.LibraryApplication.domain.member.MemberDto;
import com.example.LibraryApplication.domain.member.MemberMapper;
import com.example.LibraryApplication.domain.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Optional;

@Slf4j
@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;
    @Resource
    private MemberRepository memberRepository;


    public MemberDto addMember(MemberDto memberDto) {
        Member member = memberMapper.toEntity(memberDto);
        log.info("Adding new member...");
        memberRepository.save(member);
        log.info("New member " + member.getFirstName() + " " + member.getLastName() + " with id: "
                + member.getId() + " added!");
        return memberMapper.toDto(member);
    }

    public MemberDto findMemberById(Integer id) {
        log.info("Searching member with id " + id + "...");
        Member member = memberRepository.findMemberById(id);
        log.info("Member with id " + id + " found!");
        return memberMapper.toDto(member);
    }

    public MemberDto findByLastName(String name) {
        log.info("Searching member with name " + name + "...");
        Optional<Member> member = memberRepository.findByLastName(name);
        log.info("Member with the name " + name + " found!");
        return memberMapper.toDto(member.get());
    }
}
