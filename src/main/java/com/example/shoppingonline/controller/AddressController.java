package com.example.shoppingonline.controller;


import com.example.shoppingonline.DTO.AddressDto;
import com.example.shoppingonline.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final
    IAddressService addressService;

    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    //view all address
    @GetMapping("/find-all")
    public List<AddressDto> findAll(){
        return addressService.getAllAddressDto();
    }

    //get 1 address
    @GetMapping("/{findId}")
    public AddressDto findOne(@PathVariable Long findId){
        return addressService.findOne(findId);
    }

    //add
    @PostMapping("/add")
    public AddressDto create(@RequestBody AddressDto addressDto){
        return addressService.create(addressDto);
    }

    //update
    @PutMapping("/update")
    public AddressDto update(@RequestBody AddressDto addressDto) {
        return addressService.update(addressDto);
    }

    //delete
    @DeleteMapping("/{deleteId}")
    public List<AddressDto> delete(@PathVariable Long deleteId){
        addressService.delete(deleteId);
        return addressService.getAllAddressDto();
    }
}
