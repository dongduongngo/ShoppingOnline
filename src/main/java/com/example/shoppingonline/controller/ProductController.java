package com.example.shoppingonline.controller;

import com.example.shoppingonline.DTO.ProductDto;
import com.example.shoppingonline.service.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    //view all Product
    @GetMapping("/find-all")
    public List<ProductDto> findAll(){
        return productService.getAllProductDtos();
    }

    //get 1 product
    @GetMapping("/{findId}")
    public ProductDto findOne(@PathVariable Long findId){
        return productService.findOne(findId);
    }

    //add
    @PostMapping("/add")
    public ProductDto create(@RequestBody ProductDto productDto){
        return productService.create(productDto);
    }

    //update
    @PutMapping("/update")
    public ProductDto update(@RequestBody ProductDto productDto){
        return productService.update(productDto);
    }

    //delete
    @DeleteMapping("/{deleteId}")
    public List<ProductDto> delete(@PathVariable Long deleteId){
        productService.delete(deleteId);
        return productService.getAllProductDtos();
    }
}
