package com.yesh.kardex;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import com.yesh.kardex.model.Client;
import com.yesh.kardex.model.Role;
import com.yesh.kardex.repository.ClientRepository;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {
 
	@Autowired
    private ClientRepository clientRepository;
    public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
 
        Client client = clientRepository.findByEmail(username);
        if (client == null) {
            throw new UsernameNotFoundException(
              "No se ha encontrado el usuario: "+ username);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        // Roles para el usuario
        List<String> roles = new ArrayList<String>();
        for (Role rol : client.getRoles()) {
        	roles.add(rol.getName());
		}
        
        return  new org.springframework.security.core.userdetails.User
          (client.getEmail(), 
        		  client.getPassword().toLowerCase(), enabled, accountNonExpired, 
          credentialsNonExpired, accountNonLocked, 
          getAuthorities(roles));
    }
    
    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}