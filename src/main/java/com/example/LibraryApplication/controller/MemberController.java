package com.example.LibraryApplication.controller;


import com.example.LibraryApplication.domain.member.MemberDto;
import com.example.LibraryApplication.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/member")
@Api(value = "Member controller. Here we create member endpoints")
public class MemberController {

    @Resource
    private MemberService memberService;


    @PostMapping("/add")
    @Operation(summary = "Adds member")
    public MemberDto addMember (@RequestBody MemberDto memberDto){
        return memberService.addMember(memberDto);
    }




}
