package com.example.LibraryApplication.service.register;
import com.example.LibraryApplication.domain.user.contact.ContactService;
import com.example.LibraryApplication.service.register.RegisterRequest;
import com.example.LibraryApplication.service.register.RegisterResponse;
import com.example.LibraryApplication.service.register.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/profile")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @Resource
    private ContactService contactService;

    @PostMapping("/register")
    @Operation(summary = "Adds new user")
    public RegisterResponse registerNewUser(@RequestBody RegisterRequest request) {
        return registerService.registerNewUser(request);
    }

    @GetMapping("/user-info/by/id")
    @Operation(summary = "Finds user info by id")
    public RegisterRequest findUserInfoById (@RequestParam Integer id){
        return registerService.findUserInfoById(id);
    }

    @GetMapping("/user-info/by/lastName")
    @Operation(summary = "Finds user info by last name")
    public RegisterRequest findUserInfoByLastName (@RequestParam String lastName){
        return registerService.findUserInfoByLastName(lastName);
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