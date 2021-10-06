package com.example.shoppingonline.controller;

import com.example.shoppingonline.DTO.OrderDetailDto;
import com.example.shoppingonline.service.IOrderDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {

    private final IOrderDetailService orderDetailService;

    public OrderDetailController(IOrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    //view all orderdetail
    @GetMapping("/find-all")
    public List<OrderDetailDto> findAll(){
        return orderDetailService.getAllOrderDetailDtos();
    }

    //get 1 orderdetail
    @GetMapping("/{findId}")
    public OrderDetailDto findOne(@PathVariable Long findId){
        return orderDetailService.findOne(findId);
    }

    //add
    @PostMapping("/add")
    public OrderDetailDto create(@RequestBody OrderDetailDto orderDetailDto){
        return orderDetailService.create(orderDetailDto);
    }

    //update
    @PutMapping("/update")
    public OrderDetailDto update(@RequestBody OrderDetailDto orderDetailDto){
        return orderDetailService.update(orderDetailDto);
    }

    //delete
    @DeleteMapping("/{deleteId}")
    public List<OrderDetailDto> delete(@PathVariable Long deleteId){
        orderDetailService.delete(deleteId);
        return orderDetailService.getAllOrderDetailDtos();
    }
}
