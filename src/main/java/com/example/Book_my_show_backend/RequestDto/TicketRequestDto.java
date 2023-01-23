package com.example.Book_my_show_backend.RequestDto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter



public class TicketRequestDto {


    private List<String> requestSeat;

    private int userId;

    private int showId;

}
