package com.example.shoppingonline.serviceImpl;

import com.example.shoppingonline.DTO.ImagesDto;
import com.example.shoppingonline.entity.Category;
import com.example.shoppingonline.entity.Images;
import com.example.shoppingonline.repository.IImagesRepository;
import com.example.shoppingonline.service.IImagesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImagesServiceImpl  implements IImagesService {

    private final IImagesRepository imagesRepository;
    private final ModelMapper modelMapper;

    public ImagesServiceImpl(IImagesRepository imagesRepository, ModelMapper modelMapper) {
        this.imagesRepository = imagesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ImagesDto> getAllImagesDtos() {
        return ((List<Images>) imagesRepository
                .findAll())
                .stream()
                .map(this::convertToImagesDto)
                .collect(Collectors.toList());
    }

    @Override
    public ImagesDto create(ImagesDto imagesDto) {
        imagesDto.setImageId(null);
        Images images = imagesRepository.save(convertToImages(imagesDto));
        return convertToImagesDto(images);
    }

    @Override
    public ImagesDto update(ImagesDto imagesDto) {
        Images images = imagesRepository.save(convertToImages(imagesDto));
        return convertToImagesDto(images);
    }

    @Override
    public ImagesDto findOne(Long id) {
        return convertToImagesDto(imagesRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        imagesRepository.deleteById(id);
    }

    private ImagesDto convertToImagesDto(Images images){
        ImagesDto imagesDto = modelMapper.map(images, ImagesDto.class);
        return imagesDto;
    }
    private Images convertToImages(ImagesDto imagesDto){
        Images images = modelMapper.map(imagesDto, Images.class);
        return images;
    }
}
