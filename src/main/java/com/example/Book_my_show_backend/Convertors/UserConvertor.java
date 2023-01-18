package com.example.Book_my_show_backend.Convertors;
import com.example.Book_my_show_backend.ServiceLayer.UserService;
import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.RequestDto.UserRequestDto;
import lombok.Builder;

public class UserConvertor {

    public static UserEntity ConvertDtoToEntity(UserRequestDto userrequestdto){
        UserEntity userEntity = UserEntity.builder().name(userrequestdto.getName()).mobile(userrequestdto.getMobile()).build();
        return userEntity;
    }
}
