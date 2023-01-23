package com.example.Book_my_show_backend.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Getter
@Setter

public class ShowRequestDto {
   private LocalDate showDate;
    private LocalTime showTime;

    private String movie;

    private double multiplier;

    private int Theaterid;
}
