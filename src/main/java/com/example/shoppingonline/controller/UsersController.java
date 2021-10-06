package com.example.shoppingonline.controller;

import com.example.shoppingonline.DTO.AddressDto;
import com.example.shoppingonline.DTO.UserDto;
import com.example.shoppingonline.entity.Users;
import com.example.shoppingonline.service.IUsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final IUsersService usersService;


    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    //view all user
    @GetMapping("/find-all")
    public List<UserDto> findAll(){
        return usersService.getAllUserDtos();
    }

    //get 1 user
    @GetMapping("/{findId}")
    public UserDto findOne(@PathVariable Long findId){
        return usersService.findOne(findId);
    }

    //add
    @PostMapping("/add")
    public Users create(@RequestBody Users users){
        return usersService.create(users);
    }

    //update
    @PutMapping("/update")
    public UserDto update(@RequestBody UserDto userDto){
        return usersService.update(userDto);
    }

    //delete
    @DeleteMapping("/{deleteId}")
    public List<UserDto> delete(@PathVariable Long deleteId) {
        usersService.delete(deleteId);
        return usersService.getAllUserDtos();
    }
}
