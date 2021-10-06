package com.example.shoppingonline.serviceImpl;

import com.example.shoppingonline.DTO.CategoryDto;
import com.example.shoppingonline.DTO.UserDto;
import com.example.shoppingonline.entity.Category;
import com.example.shoppingonline.entity.Users;
import com.example.shoppingonline.repository.ICategoryRepository;
import com.example.shoppingonline.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryImpl implements ICategoryService {

    private final ICategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryImpl(ICategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> getAllCategoryDto() {
        return ((List<Category>) categoryRepository
                .findAll())
                .stream()
                .map(this::convertToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        categoryDto.setCategoryId(null);
        Category category = categoryRepository.save(convertToCategory(categoryDto));
        return convertToCategoryDto(category);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        Category category = categoryRepository.save(convertToCategory(categoryDto));
        return convertToCategoryDto(category);
    }

    @Override
    public CategoryDto findOne(Long id) {
        return convertToCategoryDto(categoryRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
    private CategoryDto convertToCategoryDto(Category category){
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    private Category convertToCategory(CategoryDto categoryDto){
        Category category = modelMapper.map(categoryDto, Category.class);
        return category;
    }
}
