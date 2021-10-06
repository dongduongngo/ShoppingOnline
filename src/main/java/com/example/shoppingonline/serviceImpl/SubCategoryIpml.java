package com.example.shoppingonline.serviceImpl;

import com.example.shoppingonline.DTO.SubCategoryDto;
import com.example.shoppingonline.entity.Category;
import com.example.shoppingonline.entity.Subcategory;
import com.example.shoppingonline.repository.ISubCategoryRepository;
import com.example.shoppingonline.service.ISubCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCategoryIpml implements ISubCategoryService {

    private final ISubCategoryRepository categoryRepository;
    private final
    ModelMapper modelMapper;

    public SubCategoryIpml(ISubCategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<SubCategoryDto> getAllCategoryDtos() {
        return ((List<Subcategory>) categoryRepository
                .findAll())
                .stream()
                .map(this::convertToSubCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryDto create(SubCategoryDto subCategoryDto) {
        subCategoryDto.setSubCategoryId(null);
        Subcategory subcategory = categoryRepository.save(convertToSubcategory(subCategoryDto));
        return convertToSubCategoryDto(subcategory);
    }

    @Override
    public SubCategoryDto update(SubCategoryDto subCategoryDto) {
        Subcategory subcategory = categoryRepository.save(convertToSubcategory(subCategoryDto));
        return convertToSubCategoryDto(subcategory);
    }

    @Override
    public SubCategoryDto findOne(Long id) {
        return convertToSubCategoryDto(categoryRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
    private SubCategoryDto convertToSubCategoryDto(Subcategory subcategory) {
        SubCategoryDto subCategoryDto = modelMapper.map(subcategory, SubCategoryDto.class);
        return subCategoryDto;
    }
    private Subcategory convertToSubcategory(SubCategoryDto subCategoryDto){
        Subcategory subcategory = modelMapper.map(subCategoryDto, Subcategory.class);
        return subcategory;
    }
}
