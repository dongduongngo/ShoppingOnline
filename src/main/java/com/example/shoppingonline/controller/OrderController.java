package com.example.shoppingonline.controller;

import com.example.shoppingonline.DTO.OrdersDto;
import com.example.shoppingonline.service.IOrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final IOrdersService ordersService;

    public OrderController(IOrdersService ordersService) {
        this.ordersService = ordersService;
    }

    //view all order
    @GetMapping("/find-all")
    public List<OrdersDto> findAll(){
        return ordersService.getAllOrdersDtos();
    }

    //get 1 address
    @GetMapping("/{findId}")
    public OrdersDto findOne(@PathVariable Long findId){
        return ordersService.findOne(findId);
    }

    //add
    @PostMapping("/add")
    public OrdersDto create(@RequestBody OrdersDto ordersDto){
        return ordersService.create(ordersDto);
    }

    //update
    @PutMapping("/update")
    public OrdersDto upadte(@RequestBody OrdersDto ordersDto){
        return ordersService.update(ordersDto);
    }

    //delete
    @DeleteMapping("/{deleteId}")
    public List<OrdersDto> delete(@PathVariable Long deleteId){
        ordersService.delete(deleteId);
        return ordersService.getAllOrdersDtos();
    }
}
