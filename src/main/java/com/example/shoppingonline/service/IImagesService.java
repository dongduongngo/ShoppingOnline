package com.example.shoppingonline.service;

import com.example.shoppingonline.DTO.ImagesDto;
import com.example.shoppingonline.entity.Images;

import java.util.List;

public interface IImagesService {
//    List<Images> getAllImages();
    List<ImagesDto> getAllImagesDtos();

    ImagesDto create(ImagesDto imagesDto);
    ImagesDto update(ImagesDto imagesDto);
    ImagesDto findOne(Long id);

    void delete(Long id);
}
