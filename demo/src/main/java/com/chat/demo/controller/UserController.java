package com.chat.demo.controller;

import com.chat.demo.entity.Role;
import com.chat.demo.entity.User;

import com.chat.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public User addUser(@RequestParam String username, @RequestParam String password) {
        User user= new User();
        user.setUsername(username);
        user.setPassword(password);

        return userService.saveUser(user);
    }

    @PostMapping ("/log")
    public User loginUser(@RequestBody User user) {
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        return userService.AuthUser(user);
    }



    @GetMapping("/users")
            public Iterable<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping ("/exit")
    public String logout(@RequestBody long id) {
        userService.logout(id);
        return "ok";
    }

}
