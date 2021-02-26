package com.yesh.kardex.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yesh.kardex.dto.ProductDTO;
import com.yesh.kardex.model.Product;
import com.yesh.kardex.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/productos")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) throws URISyntaxException {
        log.info("Solicitud REST para almacenar producto : {}", productDTO);

        Product newProduct = productService.createProduct(productDTO);
        return ResponseEntity.created(new URI("/api/products/" + newProduct.getCode())).body(newProduct);
    }

    @GetMapping("/productos")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
    	log.info("Solicitud REST para obtener los productos");
    	
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
