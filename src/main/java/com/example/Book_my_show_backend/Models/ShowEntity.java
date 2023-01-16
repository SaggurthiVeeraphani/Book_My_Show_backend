package com.example.Book_my_show_backend.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="shows")
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showdate;

    private LocalTime showtime;

    @CreationTimestamp
    private Date createdOn;

    @CreationTimestamp
    private Date updatedOn;

    @ManyToOne
    @JoinColumn
    private MoviesEntity movie;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<ShowSeatEntity> ListofSeats;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    List<TicketEntity> listOfTickets;
}
