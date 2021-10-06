package com.example.shoppingonline.serviceImpl;

import com.example.shoppingonline.DTO.UserDto;
import com.example.shoppingonline.entity.Users;
import com.example.shoppingonline.repository.IUsersRepository;
import com.example.shoppingonline.service.IUsersService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUsersService {

    private final
    IUsersRepository usersRepository;

    private final
    ModelMapper modelMapper;

    public UserServiceImpl(IUsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAllUserDtos() {
        return ((List<User>) usersRepository
                .findAll())
                .stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public Users create(Users users) {
        return null;
    }

    @Override
    public UserDto update(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    private UserDto convertToUserDto(Users users){
        UserDto userDto = modelMapper.map(users, UserDto.class);
        return userDto;
    }

    private Users convertToUser(UserDto userDto){
        Users users = modelMapper.map(userDto, Users.class);
        return users;
    }
}
