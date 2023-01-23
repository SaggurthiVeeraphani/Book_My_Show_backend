package com.example.Book_my_show_backend.ServiceLayer;

import com.example.Book_my_show_backend.Convertors.ShowConverter;
import com.example.Book_my_show_backend.Models.*;
import com.example.Book_my_show_backend.Repository.MovieRepository;
import com.example.Book_my_show_backend.Repository.ShowRepository;
import com.example.Book_my_show_backend.Repository.ShowSeatRepository;
import com.example.Book_my_show_backend.Repository.TheaterRepository;
import com.example.Book_my_show_backend.RequestDto.ShowRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    //we need to get movie repository;
    //we need to get theater repository;
    public String addshow(ShowRequestDto showRequestDto){
        ShowEntity showEntity = ShowConverter.showREquesttoENtity(showRequestDto);
        //get movie from movieRepository
        MoviesEntity movie = movieRepository.findByMovieName(showRequestDto.getMovie());

        //get theater from theaterRepository
        TheaterEntity theater = theaterRepository.findById(showRequestDto.getTheaterid()).get();

        showEntity.setTheater(theater);
        showEntity.setMovie(movie);


        //bcoz we are mapping in bi-directional mapping
        //optional things:
        theater.getListOfShows().add(showEntity);
        movie.getShowEntityList().add(showEntity);
        //theaterRepository.save(theater);


        List<ShowSeatEntity> showSeatEntitylist = createshowSeatEntity(theater.getTheaterseatEntityList());
        showEntity.setListofSeats(showSeatEntitylist);

        //for Each showseat: we need to mark that to which show it belongs (foreign key will be filled)
        for(ShowSeatEntity showseat: showSeatEntitylist){
            showseat.setShow(showEntity);
        }
        movieRepository.save(movie);
        theaterRepository.save(theater);
        //showRepository.save(showEntity); this doesn't need to be called bcoz parent save function is being called;
        //if parent class is saved no need to save child classes;

        return "show added successfully";



    }
    public List<ShowSeatEntity> createshowSeatEntity(List<TheaterSeatEntity> theaterSeatEntities){
        List<ShowSeatEntity> seats = new ArrayList<>();
        for(TheaterSeatEntity theaterSeat:theaterSeatEntities){
            ShowSeatEntity showSeat = ShowSeatEntity.builder().seatNo(theaterSeat.getSeatNo())
                                       .seatType(theaterSeat.getSeattype()).build();
            seats.add(showSeat);
        }
        showSeatRepository.saveAll(seats);
        return seats;
    }


}
