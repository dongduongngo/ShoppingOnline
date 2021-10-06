package com.example.shoppingonline.serviceImpl;

import com.example.shoppingonline.DTO.OrderDetailDto;
import com.example.shoppingonline.entity.Address;
import com.example.shoppingonline.entity.OrderDetail;
import com.example.shoppingonline.entity.Orders;
import com.example.shoppingonline.repository.IOrderDetailRepository;
import com.example.shoppingonline.service.IOrderDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    private final IOrderDetailRepository orderDetailRepository;
    private final
    ModelMapper modelMapper;

    public OrderDetailServiceImpl(IOrderDetailRepository orderDetailRepository, ModelMapper modelMapper) {
        this.orderDetailRepository = orderDetailRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderDetailDto> getAllOrderDetailDtos() {
        return ((List<OrderDetail>) orderDetailRepository
                .findAll())
                .stream()
                .map(this::convertToOrderDetailDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDetailDto create(OrderDetailDto orderDetailDto) {
        orderDetailDto.setOrderDetailId(null);
        OrderDetail orderDetail = orderDetailRepository.save(convertToOrderDetail(orderDetailDto));
        return convertToOrderDetailDto(orderDetail);
    }

    @Override
    public OrderDetailDto update(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = orderDetailRepository.save(convertToOrderDetail(orderDetailDto));
        return convertToOrderDetailDto(orderDetail);
    }

    @Override
    public OrderDetailDto findOne(Long id) {
        return convertToOrderDetailDto(orderDetailRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        orderDetailRepository.deleteById(id);
    }

    private OrderDetailDto convertToOrderDetailDto(OrderDetail orderDetail){
        OrderDetailDto orderDetailDto = modelMapper.map(orderDetail, OrderDetailDto.class);
        return orderDetailDto;
    }

    private OrderDetail convertToOrderDetail(OrderDetailDto orderDetailDto){
        OrderDetail orderDetail = modelMapper.map(orderDetailDto, OrderDetail.class);
        return orderDetail;
    }
}
