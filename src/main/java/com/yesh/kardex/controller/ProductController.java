package com.yesh.kardex.controller;

import java.net.URISyntaxException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.yesh.kardex.dto.ProductDTO;
import com.yesh.kardex.service.ProductService;

@Controller
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    
	@GetMapping("/newproduct")
    public String registerNewClient(Model model) {
		ProductDTO productDTO = new ProductDTO();
		model.addAttribute("product",productDTO);
        return "newproduct.html";
    }

    @PostMapping("/addproduct")
    public String createProduct(Model model,ProductDTO productDTO) throws URISyntaxException {
        log.info("Solicitud para almacenar producto : {}", productDTO);
        productService.createProduct(productDTO);
        ProductDTO newproductDTO = new ProductDTO();
		model.addAttribute("product",newproductDTO);
        return "newproduct.html";
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
    	log.info("Solicitud para obtener los productos");
    	
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    @GetMapping("/products/{id}")
    public ProductDTO obtenerempleado(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

}
