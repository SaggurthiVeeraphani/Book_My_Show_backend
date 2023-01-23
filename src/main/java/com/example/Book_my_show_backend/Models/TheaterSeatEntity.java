package com.example.Book_my_show_backend.Models;

import com.example.Book_my_show_backend.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TheaterSeat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String SeatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seattype;

    private int rate;

    @ManyToOne  //many seats(child) is connected to theater(parent)-----relation
    @JoinColumn
    private TheaterEntity theater;

    public TheaterSeatEntity(String SeatNo,SeatType seattype,int rate){
        this.SeatNo = SeatNo;
        this.seattype = seattype;
        this.rate = rate;
    }


}
