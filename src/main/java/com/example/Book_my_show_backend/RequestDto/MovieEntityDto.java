package com.example.Book_my_show_backend.RequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MovieEntityDto {

    private String movieName;

    private int duration;

    private Date releasedate;



}
