package com.yesh.kardex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.yesh.kardex.dto.ClientDTO;
import com.yesh.kardex.exception.ClientAlreadyExistException;
import com.yesh.kardex.exception.PasswordMismatchException;
import com.yesh.kardex.service.ClientService;

@Controller
public class ClientController {

	private final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ClientService clientService;;
	
	// Registrar nuevo usuario
	@GetMapping("/registration")
    public String registerNewClient(Model model) {
		ClientDTO client = new ClientDTO();
		model.addAttribute("client",client);
        return "registration.html";
    }

	@PostMapping("/registrationProcess")
	public String addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("client") ClientDTO client) {
		log.info("Solicitud para crear un nuevo cliente : {}", client);
		try {
			if(client.getPassword().equals(client.getMatchingPassword())) {
				clientService.registerNewClient(client);
				log.info("Cliente añadido con exito: {}", client);
			}else {
				throw new PasswordMismatchException("Contraseñas diferentes");
			}
		} catch (PasswordMismatchException psme) {
			log.error(psme.getMessage());
			return "registration.html";
		} catch (ClientAlreadyExistException caee) {
			log.error(caee.getMessage());
			return "registration.html";
		}
		return "login.html";
	}

}
