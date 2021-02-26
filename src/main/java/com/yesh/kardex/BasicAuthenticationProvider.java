package com.yesh.kardex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.security.core.authority.*;

import com.yesh.kardex.model.Client;
import com.yesh.kardex.model.Role;
import com.yesh.kardex.repository.ClientRepository;

@Component
public class BasicAuthenticationProvider implements AuthenticationProvider {
	
	// Logger
	private static final Logger log = LoggerFactory.getLogger(BasicAuthenticationProvider.class);
	
	@Autowired
    private ClientRepository clientRepository;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    	// Función para codificar, lista de roles para los usuarios
    	BCryptPasswordEncoder Encoder = new BCryptPasswordEncoder();
    	List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    	
    	// Comprobar si el usuario existe en la base de datos
        final UsernamePasswordAuthenticationToken upAuth = (UsernamePasswordAuthenticationToken) authentication;
        final String username = (String) authentication.getPrincipal().toString();
        final String password = (String) upAuth.getCredentials().toString();
        Client client = clientRepository.findByUsername(username);
        final String storedPassword = (client!=null)?client.getPassword():null;
        // Verificar si la contraseña fue ingresada y si ádemas es correcta
        boolean passwordsMatch = Encoder.matches(password, storedPassword);
        if (Objects.equals(password, "") || !passwordsMatch || storedPassword==null) {
            throw new BadCredentialsException("Clave incorrecta o cliente inexistente");
        }
        
        // Lee los roles del usuario
        for (Role role : client.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        // Concede acceso al usuario
        final Object principal = authentication.getPrincipal();
        final UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
            principal, authentication.getCredentials(),
            authorities);
        result.setDetails(authentication.getDetails());
        
        log.info("El usuario '"+ username + "' ha ingresado.");
        System.out.println("El usuario '"+ username + "' ha ingresado.");
        return result;
    }

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
