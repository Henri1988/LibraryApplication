package com.example.LibraryApplication.controller;
import com.example.LibraryApplication.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/member")
@Api(value = "Member controller. Here we create member endpoints")
public class MemberController {

    @Resource
    private MemberService memberService;


//    @PostMapping("/add")
//    @Operation(summary = "Adds member")
//    public MemberDto addMember (@RequestBody MemberDto memberDto){
//        return memberService.addMember(memberDto);
//    }
//
//    @GetMapping("/by/id")
//    @Operation(summary = "Searches member by id")
//    public MemberDto findMemberById(@RequestParam Integer id){
//        return memberService.findMemberById(id);
//    }
//
//
//    @GetMapping("/by/last-name")
//    @Operation(summary = "Finds member by last name")
//    public MemberDto findByLastName(@RequestParam String name){
//        return memberService.findByLastName(name);
//    }
}
