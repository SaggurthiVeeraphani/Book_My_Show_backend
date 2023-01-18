package com.example.Book_my_show_backend.ServiceLayer;

import com.example.Book_my_show_backend.Convertors.UserConvertor;
import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.Repository.UserRepository;
import com.example.Book_my_show_backend.RequestDto.UserRequestDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public String createUser(UserRequestDto userrequestdto){
     try{
         UserEntity user = UserConvertor.ConvertDtoToEntity(userrequestdto);
         userRepository.save(user);
     }catch(Exception e){
         return "create userentity has an issue";
     }
     return "User is successfully created";
    }
}
