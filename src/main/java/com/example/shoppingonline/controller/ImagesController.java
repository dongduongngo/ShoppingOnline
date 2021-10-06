package com.example.shoppingonline.controller;

import com.example.shoppingonline.DTO.ImagesDto;
import com.example.shoppingonline.service.IImagesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImagesController {

    private final IImagesService imagesService;

    public ImagesController(IImagesService imagesService) {
        this.imagesService = imagesService;
    }

    //view all image
    @GetMapping("/find-all")
    public List<ImagesDto> findAll(){
        return imagesService.getAllImagesDtos();
    }

    //get 1 image
    @GetMapping("/{findId}")
    public ImagesDto findOne(@PathVariable Long findId){
        return imagesService.findOne(findId);
    }

    //add
    @PostMapping("/add")
    public ImagesDto create(@RequestBody ImagesDto imagesDto){
        return imagesService.create(imagesDto);
    }

    //update
    @PutMapping("/update")
    public ImagesDto update(@RequestBody ImagesDto imagesDto){
        return imagesService.update(imagesDto);
    }

    //delete
    @DeleteMapping("/{deleteId}")
    public List<ImagesDto> delete(@PathVariable Long deleteId){
        imagesService.delete(deleteId);
        return imagesService.getAllImagesDtos();
    }
}
