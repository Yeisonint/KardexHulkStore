package com.yesh.kardex.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yesh.kardex.dto.ClientDTO;
import com.yesh.kardex.exception.ClientAlreadyExistException;
import com.yesh.kardex.model.Client;
import com.yesh.kardex.model.Role;
import com.yesh.kardex.repository.ClientRepository;
import com.yesh.kardex.repository.RoleRepository;

@Service
@Transactional
public class ClientService {

	private final Logger log = LoggerFactory.getLogger(ProductService.class);
	BCryptPasswordEncoder Encoder = new BCryptPasswordEncoder();

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(client -> {
            ClientDTO clientDTO = new ClientDTO(
            		client.getId(),
            		client.getName(),
            		client.getUsername(),
            		client.getPassword(),
            		client.getEmail()
            		);
            return clientDTO;
        }).collect(Collectors.toList());
    }
    
    @Transactional
    public Client registerNewClient(ClientDTO clientDTO) 
      throws ClientAlreadyExistException {
        
        if (emailExists(clientDTO.getEmail())) {   
            throw new ClientAlreadyExistException(
              "Ya existe un cliente con el mismo correo: "
              + clientDTO.getEmail());
        }
        Client client = new Client();    
        client.setName(clientDTO.getName());
        client.setUsername(clientDTO.getUsername());
        client.setPassword(Encoder.encode(clientDTO.getPassword()));
        client.setEmail(clientDTO.getEmail());
        client.setEnabled(true);
        
        // Roles para el usuario nuevo
        Role userRole = roleRepository.findByName("ROLE_USER");
        Collection<Role> roles = new ArrayList<Role>();
        roles.add(userRole);
        client.setRoles(roles);
        
        log.debug("Creada información para el cliente: {}", client);
        return clientRepository.save(client);       
    }

    private boolean emailExists(String email) {
        return clientRepository.findByEmail(email) != null;
    }
}
