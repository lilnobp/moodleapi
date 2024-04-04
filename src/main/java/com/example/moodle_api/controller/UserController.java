package com.example.moodle_api.controller;

import com.example.moodle_api.model.User;
import com.example.moodle_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/user_management")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("user")
    public User insertUser(User user){
        return userService.saveUser(user);
    }
}
