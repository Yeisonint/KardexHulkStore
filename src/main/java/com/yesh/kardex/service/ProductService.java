package com.yesh.kardex.service;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yesh.kardex.dto.ProductDTO;
import com.yesh.kardex.model.Product;
import com.yesh.kardex.repository.ProductRepository;


@Service
@Transactional
public class ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setCode(productDTO.getCode());
        product.setImg(productDTO.getIMG());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());

        productRepository.save(product);

        log.debug("Creada información para el producto: {}", product);

        return product;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setCode(product.getCode());
            productDTO.setIMG(product.getImg());
            productDTO.setDescription(product.getDescription());
            productDTO.setQuantity(product.getQuantity());
            productDTO.setPrice(product.getPrice());
            return productDTO;
        }).collect(Collectors.toList());
    }

}
