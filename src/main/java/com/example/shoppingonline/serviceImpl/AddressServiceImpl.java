package com.example.shoppingonline.serviceImpl;

import com.example.shoppingonline.DTO.AddressDto;
import com.example.shoppingonline.entity.Address;
import com.example.shoppingonline.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    private final
    IAddressService iAddressService;

    public AddressServiceImpl(IAddressService iAddressService) {
        this.iAddressService = iAddressService;
    }

    @Override
    public List<Address> getAllAddress() {
        return null;
    }

    @Override
    public List<AddressDto> getAllAddressDto() {
        return null;
    }

    @Override
    public AddressDto create(AddressDto addressDto) {
        return null;
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
