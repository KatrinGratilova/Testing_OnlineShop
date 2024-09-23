package org.katrin.testingglovo.service;

import lombok.AllArgsConstructor;
import org.katrin.testingglovo.converter.ProductConverter;
import org.katrin.testingglovo.dto.ProductDto;
import org.katrin.testingglovo.entity.ProductEntity;
import org.katrin.testingglovo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class ProductService {
    private ProductRepository productRepository;

    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(ProductConverter::toDto).toList();
    }

    public ProductDto getById(int id) {
        return productRepository.findById(id).map(ProductConverter::toDto).orElseThrow();
    }

    public ProductDto save(ProductDto productDto) {
        ProductEntity productEntity = productRepository.save(ProductConverter.toEntity(productDto));
        return ProductConverter.toDto(productEntity);
    }

    public ProductDto update(ProductDto productDto) {
        ProductEntity productEntity = productRepository.save(ProductConverter.toEntity(productDto));
        return ProductConverter.toDto(productEntity);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
