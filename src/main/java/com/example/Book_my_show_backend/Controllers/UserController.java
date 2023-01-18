package com.example.Book_my_show_backend.Controllers;


import com.example.Book_my_show_backend.RequestDto.UserRequestDto;
import com.example.Book_my_show_backend.ServiceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userservice;


    @PostMapping("/add")
    public String addUser(@RequestBody() UserRequestDto userrequestDto){
        return userservice.createUser(userrequestDto);

    }

    // HW --- find user by name

    // HW --- find all users
}
