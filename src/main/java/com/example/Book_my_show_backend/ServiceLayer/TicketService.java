package com.example.Book_my_show_backend.ServiceLayer;

import com.example.Book_my_show_backend.Models.ShowEntity;
import com.example.Book_my_show_backend.Models.ShowSeatEntity;
import com.example.Book_my_show_backend.Models.TicketEntity;
import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.Repository.ShowRepository;
import com.example.Book_my_show_backend.Repository.TicketRepository;
import com.example.Book_my_show_backend.Repository.UserRepository;
import com.example.Book_my_show_backend.RequestDto.TicketRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String addTicket(TicketRequestDto ticketRequestDto) throws Exception{
        //get the request
        List<String> Requestedseat = ticketRequestDto.getRequestSeat();

       //get showEntity by showid;
        ShowEntity showEntity = showRepository.findById(ticketRequestDto.getShowId()).get();

        //get userEntity by userID;
        UserEntity userEntity = userRepository.findById(ticketRequestDto.getUserId()).get();

        // Get show seats from show entity;
        List<ShowSeatEntity> showSeatEntityList = showEntity.getListofSeats();

        //iterate through the showSeatEntity and validate whether the requested seats are booked Or Not
        List<ShowSeatEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatEntity seatEntity:showSeatEntityList){

            String SeatNo = seatEntity.getSeatNo();
            if(seatEntity.isBooked()==false && Requestedseat.contains(SeatNo)){
                bookedSeats.add(seatEntity);
            }
        }
        // Failure
        if(bookedSeats.size()!=Requestedseat.size()){
            //failure handling //seats requested by user are not available;
            throw new Exception("Requested seats are not available");
        }
        //success
        //this means all requested seats are available
        TicketEntity ticketEntity = new TicketEntity();

        double total_Amount = 0;
        double multiplier = showEntity.getMultiplier();

        //for alloted seats
        String allotedSeats = "";

        int rate = 0;
        //calculating amount,setting booked status,setting
        for(ShowSeatEntity showSeatEntity:bookedSeats){
            showSeatEntity.setBooked(true);
            showSeatEntity.setBookedAt(new Date());
            showSeatEntity.setShow(showEntity);
            showSeatEntity.setTicket(ticketEntity);

            String seatNo = showSeatEntity.getSeatNo();

            allotedSeats = allotedSeats + seatNo +",";
            if(seatNo.charAt(0)=='1')
                rate = 200;
            else
                rate = 250;
            total_Amount = total_Amount + multiplier*rate;
        }
        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAmount((int) total_Amount);
        ticketEntity.setShow(showEntity);
        ticketEntity.setUser(userEntity);
        ticketEntity.setAllotedSeats(allotedSeats);

        ticketEntity.setListOfSeats(bookedSeats);

        //Bidirectional part is pending

        ticketRepository.save(ticketEntity);

        return "Successfully ticket is created";
    }


}
