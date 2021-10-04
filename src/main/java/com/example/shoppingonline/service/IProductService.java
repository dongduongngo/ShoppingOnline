package com.example.shoppingonline.service;

import com.example.shoppingonline.DTO.ProductDto;
import com.example.shoppingonline.entity.Product;

import java.util.List;

public interface IProductService {
//    List<Product> getAllProducts();
    List<ProductDto> getAllProductDtos();

    ProductDto create(ProductDto productDto);
    ProductDto update(ProductDto productDto);

    ProductDto findOne(Long id);

    void delete(Long id);
}
