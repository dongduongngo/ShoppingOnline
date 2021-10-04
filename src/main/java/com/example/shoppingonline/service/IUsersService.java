package com.example.shoppingonline.service;

import com.example.shoppingonline.DTO.UserDto;
import com.example.shoppingonline.entity.Users;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IUsersService {
//    List<Users> getAllUsers();
    List<UserDto> getAllUserDtos();

    Users create(Users users);
    UserDto update(UserDto userDto);

    UserDto findOne(Long id);

    void delete(Long id);
}
