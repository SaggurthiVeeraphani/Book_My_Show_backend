package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.RequestDto.MovieEntityDto;
import com.example.Book_my_show_backend.ServiceLayer.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-Movie")
    public String addMovie(@RequestBody() MovieEntityDto movieEntityDto){
        return movieService.createMovie(movieEntityDto);
    }

    // HW get movie by name

}
