package com.yesh.kardex.controller;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yesh.kardex.dto.ProductDTO;
import com.yesh.kardex.service.ProductService;

@Controller
public class ShoppingCartController {
	
	private final Logger log = LoggerFactory.getLogger(ShoppingCartController.class);
	
	@Autowired
    private ProductService productService;
    
	@GetMapping("/shoppingcart")
    public String registerNewClient(Model model) {
		ProductDTO productDTO = new ProductDTO();
		model.addAttribute("product",productDTO);
        return "newproduct.html";
    }

    @PostMapping("/shoppingcart")
    public String createProduct(Model model,ProductDTO productDTO) throws URISyntaxException {
        log.info("Solicitud para almacenar producto : {}", productDTO);
        productService.createProduct(productDTO);
        ProductDTO newproductDTO = new ProductDTO();
		model.addAttribute("product",newproductDTO);
        return "newproduct.html";
    }

}
