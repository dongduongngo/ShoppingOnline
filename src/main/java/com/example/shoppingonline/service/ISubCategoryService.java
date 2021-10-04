package com.example.shoppingonline.service;

import com.example.shoppingonline.DTO.SubCategoryDto;
import com.example.shoppingonline.entity.Subcategory;

import java.util.List;

public interface ISubCategoryService {
//    List<Subcategory> getAllSubcategories();
    List<SubCategoryDto> getAllCategoryDtos();

    SubCategoryDto create(SubCategoryDto subCategoryDto);
    SubCategoryDto update(SubCategoryDto subCategoryDto);

    SubCategoryDto findOne(Long id);

    void delete(Long id);
}
