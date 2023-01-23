package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.RequestDto.TicketRequestDto;
import com.example.Book_my_show_backend.ServiceLayer.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookticket(@RequestBody()TicketRequestDto ticketRequestDto){
        try{
            return ticketService.addTicket(ticketRequestDto);
        }catch(Exception e){
            return "Requested seats are not available";
        }
    }
}
