package com.example.LibraryApplication.controller;


import com.example.LibraryApplication.service.register.RegisterRequest;
import com.example.LibraryApplication.service.register.RegisterResponse;
import com.example.LibraryApplication.service.register.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/profile")
public class RegisterController {

    @Resource
    private RegisterService registerService;


    @PostMapping("/register")
    @Operation(summary = "Adds new user")
    public RegisterResponse registerNewUser(@RequestBody RegisterRequest request) {
        return registerService.registerNewUser(request);
    }

    public RegisterRequest findUserById (Integer id){
        return registerService.findUserById(id);
    }






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
