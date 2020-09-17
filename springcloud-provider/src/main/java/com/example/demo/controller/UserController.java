package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.utils.SessionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        User user = new User();
        user.setAccount("Tracy");
        user.setPassword("123456");
        SessionUtils.setUser(request,user);
        return "success";
    }
}
