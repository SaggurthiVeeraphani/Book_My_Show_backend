package com.example.Book_my_show_backend.Convertors;

import com.example.Book_my_show_backend.Models.ShowEntity;
import com.example.Book_my_show_backend.RequestDto.ShowRequestDto;

public class ShowConverter {
    public static ShowEntity showREquesttoENtity(ShowRequestDto showRequestDto){
        ShowEntity showEntity = ShowEntity.builder().showdate(showRequestDto.getShowDate())
                .multiplier(showRequestDto.getMultiplier()).showtime(showRequestDto.getShowTime()).build();
        return showEntity;

    }
}
