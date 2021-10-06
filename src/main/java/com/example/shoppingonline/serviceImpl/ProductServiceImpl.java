package com.example.shoppingonline.serviceImpl;

import com.example.shoppingonline.DTO.ProductDto;
import com.example.shoppingonline.entity.Category;
import com.example.shoppingonline.entity.Product;
import com.example.shoppingonline.repository.IProductRepository;
import com.example.shoppingonline.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final ModelMapper modelMapper;
    private final IProductRepository productRepository;

    public ProductServiceImpl(ModelMapper modelMapper, IProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProductDtos() {
        return ((List<Product>) productRepository
                .findAll())
                .stream()
                .map(this::convertToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        productDto.setProductId(null);
        Product product = productRepository.save(convertToProduct(productDto));
        return convertToProductDto(product);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Product product = productRepository.save(convertToProduct(productDto));
        return convertToProductDto(product);
    }

    @Override
    public ProductDto findOne(Long id) {
        return convertToProductDto(productRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    private ProductDto convertToProductDto(Product product){
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    private Product convertToProduct(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }
}
