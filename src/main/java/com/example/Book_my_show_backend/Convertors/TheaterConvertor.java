package com.example.Book_my_show_backend.Convertors;

import com.example.Book_my_show_backend.Models.TheaterEntity;
import com.example.Book_my_show_backend.RequestDto.MovieTheaterDTo;

public class TheaterConvertor {
    public static TheaterEntity ConvertTheaterDtoToEntity(MovieTheaterDTo movieTheaterDTo){
        TheaterEntity theaterEntity = TheaterEntity.builder().name(movieTheaterDTo.getName()).city(movieTheaterDTo.getCity())
                .address(movieTheaterDTo.getAddress()).build();
        return theaterEntity;
    }
}
