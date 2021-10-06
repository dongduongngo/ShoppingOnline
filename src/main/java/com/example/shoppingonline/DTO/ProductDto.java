package com.example.shoppingonline.DTO;

import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private Long categoryId;
    private Long subCategoryId;
    private String title;
    private String description;
    private double price;
    private int quanity;
    private long userId;
    private int view;
    private String sex;
    private String vaccination;
    private String insurance;
    private String status;
}
