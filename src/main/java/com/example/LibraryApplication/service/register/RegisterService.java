package com.example.LibraryApplication.service.register;


import com.example.LibraryApplication.domain.user.user.User;
import com.example.LibraryApplication.service.contact.ContactService;
import com.example.LibraryApplication.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class RegisterService {

    @Resource
    private UserService userService;
    @Resource
    private ContactService contactService;



    public RegisterResponse registerNewUser(RegisterRequest request) {
        User user = userService.addNewUser(request);
        contactService.addNewContact(user, request);
//        userRoleService.addNewUserRole(user.getId());
        return new RegisterResponse(user.getId());
    }

    public RegisterRequest findUserById(Integer id) {
        RegisterRequest response = new RegisterRequest();
        log.info("Searching member with id " + id + "...");
        User user =userService.findUser(id);


        return response;




    }


    public MemberDto findMemberById(Integer id) {
//        log.info("Searching member with id " + id + "...");
//        Member member = memberRepository.findMemberById(id);
//        log.info("Member with id " + id + " found!");
//        return memberMapper.toDto(member);
//    }
}
