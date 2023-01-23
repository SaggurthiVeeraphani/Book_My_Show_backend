package com.example.Book_my_show_backend.Controllers;


import com.example.Book_my_show_backend.RequestDto.UserRequestDto;
import com.example.Book_my_show_backend.ServiceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/get-user/{name}")
    public UserRequestDto getUser(@PathVariable(name = "name")String name){
        return userservice.getUserByname(name);
    }

    // HW --- find all users
}
