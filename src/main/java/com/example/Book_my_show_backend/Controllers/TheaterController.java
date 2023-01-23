package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.RequestDto.MovieTheaterDTo;
import com.example.Book_my_show_backend.ServiceLayer.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public String addTheater(@RequestBody() MovieTheaterDTo movieTheaterDTo){
        return theaterService.addTheater(movieTheaterDTo);

    }
    //HW -----get theaters


    //HW ----get all theaters

}
