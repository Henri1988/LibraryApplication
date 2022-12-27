package com.example.LibraryApplication.controller;


import com.example.LibraryApplication.service.register.RegisterService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RegisterController {

    @Resource
    private RegisterService registerService;



}
