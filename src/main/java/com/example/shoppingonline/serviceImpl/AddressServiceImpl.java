package com.example.shoppingonline.serviceImpl;

import com.example.shoppingonline.DTO.AddressDto;
import com.example.shoppingonline.entity.Address;
import com.example.shoppingonline.repository.IAddressRepository;
import com.example.shoppingonline.service.IAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements IAddressService {

    private final
    IAddressRepository addressRepository;
    private final
    ModelMapper modelMapper;

    public AddressServiceImpl(IAddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<AddressDto> getAllAddressDto()
    {
        return ((List<Address>) addressRepository
                .findAll())
                .stream()
                .map(this::convertToAddressDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto create(AddressDto addressDto)
    {
        addressDto.setAddressId(null);
        Address address = addressRepository.save(convertToAddress(addressDto));
        return convertToAddressDto(address);
    }

    @Override
    public AddressDto update(AddressDto addressDto)
    {
        Address address = addressRepository.save(convertToAddress(addressDto));
        return convertToAddressDto(address);
    }

    @Override
    public AddressDto findOne(Long id) {
        return convertToAddressDto(addressRepository.getById(id));
    }


    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    private AddressDto convertToAddressDto(Address address) {
        AddressDto addressDto = modelMapper.map(address, AddressDto.class);
//        addressDto.setUserId(address.getUserAddress().getUserId());
        return addressDto;
    }
    private Address convertToAddress(AddressDto addressDto){
        Address address = modelMapper.map(addressDto, Address.class);
        return address;
    }
}
