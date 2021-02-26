package com.yesh.kardex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@ComponentScan("com.yesh.kardex")
@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
    private BasicAuthenticationProvider authProvider;
	
	private static Logger log = LogManager.getLogger(ConfigSecurity.class);
    
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		// Lugares permitidos a cualquiera
		http
		.authorizeRequests().antMatchers("/").permitAll().and()
    	.authorizeRequests().antMatchers("/public/**").permitAll().and()
    	.authorizeRequests().antMatchers("/registration").permitAll().and()
    	.authorizeRequests().antMatchers("/registrationProcess").permitAll().and()
    	.authorizeRequests().antMatchers("/h2-console/**").permitAll().and()
    	.formLogin().loginPage("/login").defaultSuccessUrl("/", true).permitAll().and()
    	.authorizeRequests().antMatchers("/api/**").permitAll();
		
		// Cerrar sesión
		http
		.logout().logoutUrl("/logout")
	      .logoutSuccessUrl("/")
	      .invalidateHttpSession(true);
		
		// Autenticación propia
		http.authenticationProvider(authProvider);
		
		// Permite la consola H2
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		// Cualquie otra solicitud se redirige al login
		http.authorizeRequests()
	      .anyRequest().authenticated()
	      .and().formLogin().permitAll();
		
		log.debug("Iniciado el servidor con Spring Security.");
	}

}