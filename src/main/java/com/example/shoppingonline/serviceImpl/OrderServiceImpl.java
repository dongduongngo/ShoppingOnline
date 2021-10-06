package com.example.shoppingonline.serviceImpl;

import com.example.shoppingonline.DTO.OrdersDto;
import com.example.shoppingonline.entity.Category;
import com.example.shoppingonline.entity.Orders;
import com.example.shoppingonline.repository.IOrderRepository;
import com.example.shoppingonline.service.IOrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrdersService {

    private final IOrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(IOrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrdersDto> getAllOrdersDtos() {
        return ((List<Orders>) orderRepository
                .findAll())
                .stream()
                .map(this::convertToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrdersDto create(OrdersDto ordersDto) {
        ordersDto.setOrderId(null);
        Orders orders = orderRepository.save(convertToOrder(ordersDto));
        return convertToOrderDto(orders);
    }

    @Override
    public OrdersDto update(OrdersDto ordersDto) {
        Orders orders = orderRepository.save(convertToOrder(ordersDto));
        return convertToOrderDto(orders);
    }

    @Override
    public OrdersDto findOne(Long id) {
        return convertToOrderDto(orderRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    private OrdersDto convertToOrderDto(Orders orders){
        OrdersDto ordersDto = modelMapper.map(orders, OrdersDto.class);
        return ordersDto;
    }
    private Orders convertToOrder(OrdersDto ordersDto){
        Orders orders = modelMapper.map(ordersDto, Orders.class);
        return orders;
    }
}
