package com.example.try_upload_files.controller;

import com.example.try_upload_files.dto.UserDto;
import com.example.try_upload_files.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String register(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }



}
