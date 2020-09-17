package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.util.SessionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class UserController {

    @RequestMapping("/share")
    public String share(){

        User user = SessionUtils.getUser();
        return user.getAccount();
    }

}
