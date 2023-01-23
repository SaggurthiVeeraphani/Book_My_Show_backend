package com.example.Book_my_show_backend.ServiceLayer;

import com.example.Book_my_show_backend.Convertors.TheaterConvertor;
import com.example.Book_my_show_backend.Models.TheaterEntity;
import com.example.Book_my_show_backend.Models.TheaterSeatEntity;
import com.example.Book_my_show_backend.Repository.TheaterRepository;
import com.example.Book_my_show_backend.Repository.TheaterSeatRepository;
import com.example.Book_my_show_backend.RequestDto.MovieTheaterDTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.Book_my_show_backend.Enums.SeatType.CLASSIC;
import static com.example.Book_my_show_backend.Enums.SeatType.PLATINUM;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    public String addTheater(MovieTheaterDTo movieTheaterDTo){

        try{
            TheaterEntity theaterEntity = TheaterConvertor.ConvertTheaterDtoToEntity(movieTheaterDTo);

            List<TheaterSeatEntity> theater = createSeats();

            theaterEntity.setTheaterseatEntityList(theater);
            //for each theaterseat we need to we need to set the theater entity;
            for(TheaterSeatEntity theaterSeatEntity:theater){
                theaterSeatEntity.setTheater(theaterEntity);
            }

            theaterRepository.save(theaterEntity);

        }catch(Exception e){
            return "add theater has some issue";
        }
        return "Theater added successfully";

    }
    public List<TheaterSeatEntity> createSeats(){
        List<TheaterSeatEntity> theaterseats = new ArrayList<>();
//        TheaterSeatEntity seat1 = new TheaterSeatEntity("1A",CLASSIC,200);
//        TheaterSeatEntity seat2 = new TheaterSeatEntity("1B",CLASSIC,200);
//        TheaterSeatEntity seat3 = new TheaterSeatEntity("1C",CLASSIC,200);
//        TheaterSeatEntity seat4 = new TheaterSeatEntity("1D",CLASSIC,200);
//        TheaterSeatEntity seat5 = new TheaterSeatEntity("1E",CLASSIC,200);
//        TheaterSeatEntity seat6 = new TheaterSeatEntity("2A",PLATINUM,250);
//        TheaterSeatEntity seat7 = new TheaterSeatEntity("2B",PLATINUM,250);
//        TheaterSeatEntity seat8 = new TheaterSeatEntity("2C",PLATINUM,250);
//        TheaterSeatEntity seat9 = new TheaterSeatEntity("2D",PLATINUM,250);
//        TheaterSeatEntity seat10 = new TheaterSeatEntity("2E",PLATINUM,250);
//        theaterseats.add(seat1);
//        theaterseats.add(seat2);
//        theaterseats.add(seat3);
//        theaterseats.add(seat4);
//        theaterseats.add(seat5);
//        theaterseats.add(seat6);
//        theaterseats.add(seat7);
//        theaterseats.add(seat8);
//        theaterseats.add(seat9);
//        theaterseats.add(seat10);

        for(int i=0;i<10;i++){
            if(i<5) {
                char ch = (char) ('A' + i);
                String Seatno = "1" + ch;
                TheaterSeatEntity theaterseat = new TheaterSeatEntity(Seatno,CLASSIC,200);
                theaterseats.add(theaterseat);
            }
            else{
                char ch = (char)('A'+ i-5);
                String Seatno = "2"+ch;
                TheaterSeatEntity theaterSeat = new TheaterSeatEntity(Seatno,PLATINUM,250);
                theaterseats.add(theaterSeat);
            }

        }

        theaterSeatRepository.saveAll(theaterseats);



        return theaterseats;

    }
}
