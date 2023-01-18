package com.example.Book_my_show_backend.ServiceLayer;

import com.example.Book_my_show_backend.Convertors.MovieConvertor;
import com.example.Book_my_show_backend.Models.MoviesEntity;
import com.example.Book_my_show_backend.Repository.MovieRepository;
import com.example.Book_my_show_backend.RequestDto.MovieEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String createMovie(MovieEntityDto movieEntityDto){
        try{
            MoviesEntity moviesEntity = MovieConvertor.ConvertDtoTOentity(movieEntityDto);
            movieRepository.save(moviesEntity);
        }catch (Exception e){
            return "Issue in create_Movie";
        }
        return "Movie added successfully";
    }
}
