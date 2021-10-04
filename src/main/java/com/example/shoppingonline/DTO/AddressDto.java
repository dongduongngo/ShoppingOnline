package com.example.shoppingonline.DTO;

import lombok.Data;

@Data
public class AddressDto {
    private Long addressId;
    private UserDto userDto;
    private String name;
    private String address;
    private int priority;
}
