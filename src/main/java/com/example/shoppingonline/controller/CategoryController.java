package com.example.shoppingonline.controller;

import com.example.shoppingonline.DTO.AddressDto;
import com.example.shoppingonline.DTO.CategoryDto;
import com.example.shoppingonline.service.ICategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //view all category
    @GetMapping("/find-all")
    public List<CategoryDto> findAll(){
        return categoryService.getAllCategoryDto();
    }

    //get 1 category
    @GetMapping("/{findId}")
    public CategoryDto findOne(@PathVariable Long findId){
        return categoryService.findOne(findId);
    }

    //add
    @PostMapping("/add")
    public CategoryDto create(@RequestBody CategoryDto categoryDto){
        return categoryService.create(categoryDto);
    }

    //update
    @PutMapping("/update")
    public CategoryDto update(@RequestBody CategoryDto categoryDto){
        return categoryService.update(categoryDto);
    }

    //delete
    @DeleteMapping("/{deleteId}")
    public List<CategoryDto> delete(@PathVariable Long deleteId){
        categoryService.delete(deleteId);
        return categoryService.getAllCategoryDto();
    }
}
