package com.example.shoppingonline.DTO;

import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private ViewUserDto categoryId;
    private ViewSubCategoryDto subCategoryId;
    private String title;
    private String description;
    private double price;
    private int quanity;
    private ViewUserDto userId;
    private int view;
    private String sex;
    private String vaccination;
    private String insurance;
    private String status;
}
