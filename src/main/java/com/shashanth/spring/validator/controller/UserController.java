package com.shashanth.spring.validator.controller;

import com.shashanth.spring.validator.model.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    @PostMapping("/save")
    public String add(@Valid @RequestBody User user) {
        return "Added new user";
    }

}
