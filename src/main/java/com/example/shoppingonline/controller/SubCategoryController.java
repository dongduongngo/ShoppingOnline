package com.example.shoppingonline.controller;

import com.example.shoppingonline.DTO.SubCategoryDto;
import com.example.shoppingonline.service.ISubCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {

    private final ISubCategoryService subCategoryService;

    public SubCategoryController(ISubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    //view all subcategory
    @GetMapping("/find-all")
    public List<SubCategoryDto> findAll(){
        return subCategoryService.getAllCategoryDtos();
    }

    //get 1 subcategory
    @GetMapping("/{findId}")
    public SubCategoryDto findOne(@PathVariable Long findId){
        return subCategoryService.findOne(findId);
    }

    //add
    @PostMapping("/add")
    public SubCategoryDto create(@RequestBody SubCategoryDto subCategoryDto){
        return subCategoryService.create(subCategoryDto);
    }

    //update
    @PutMapping("/update")
    public SubCategoryDto update(@RequestBody SubCategoryDto subCategoryDto){
        return subCategoryService.update(subCategoryDto);
    }

    //delete
    @DeleteMapping("/{deleteId}")
    public List<SubCategoryDto> delete(@PathVariable Long deleteId){
        subCategoryService.delete(deleteId);
        return subCategoryService.getAllCategoryDtos();
    }
}
