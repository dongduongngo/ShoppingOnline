package com.example.shoppingonline.DTO;

import lombok.Data;

@Data
public class AddressDto {
    private Long addressId;
    private ViewUserDto user;
    private String name;
    private String address;
    private int priority;
}
