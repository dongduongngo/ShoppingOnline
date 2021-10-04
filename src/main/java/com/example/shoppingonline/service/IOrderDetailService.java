package com.example.shoppingonline.service;

import com.example.shoppingonline.DTO.OrderDetailDto;
import com.example.shoppingonline.entity.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
//    List<OrderDetail> getAllOrderDetails();
    List<OrderDetailDto> getAllOrderDetailDtos();

    OrderDetailDto create(OrderDetailDto orderDetailDto);
    OrderDetailDto update(OrderDetailDto orderDetailDto);

    OrderDetailDto findOne(Long id);

    void delete(Long id);
 }
