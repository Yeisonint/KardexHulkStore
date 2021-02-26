package com.yesh.kardex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.yesh.kardex.dto.ProductDTO;
import com.yesh.kardex.service.ProductService;

@Controller
public class WebController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
    public String index(Model model) {
		List<ProductDTO> products = productService.getAllProducts();
    	model.addAttribute("products",products);
        return "index.html";
    }
	
    // Iniciar sesión
    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }
    
    // Cerrar sesión
    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login.html";
    }

}
