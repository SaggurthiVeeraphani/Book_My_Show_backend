package com.example.Book_my_show_backend.Convertors;

import com.example.Book_my_show_backend.Models.MoviesEntity;
import com.example.Book_my_show_backend.RequestDto.MovieEntityDto;

public class MovieConvertor {
    public static MoviesEntity ConvertDtoTOentity(MovieEntityDto moviesEntityDto){
        MoviesEntity movies = MoviesEntity.builder().movieName(moviesEntityDto.getMovieName())
                .duration(moviesEntityDto.getDuration()).releaseDate(moviesEntityDto.getReleasedate()).build();

        return movies;
    }
}
