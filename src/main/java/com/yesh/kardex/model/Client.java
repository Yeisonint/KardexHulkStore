package com.yesh.kardex.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente")
public class Client implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Nombre")
    private String name;
    @Column(name = "Usuario")
    private String username;
    @Column(name = "Correo")
    private String email;
    @Column(name = "Clave")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( 
        name = "Roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;
    @Column(name = "Habilitado")
    private boolean enabled;

	public Client() {
	}
	
	public Client(long id,String name,String username,String email,String password,Collection<Role> roles, boolean enabled) {
		this.id = id;
		setName(name);
		setUsername(username);
		setEmail(email);
		setPassword(password);
		setRoles(roles);
		setEnabled(enabled);
	}

	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> role) {
		this.roles = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", usuario='" + username + '\'' +
                ", nombre='" + name + '\'' +
                ", correo='" + email + '\'' +
                ", clave='" + password + '\'' +
                ", rol='" + roles + '\'' +
                ", habilitado='" + enabled + '\'' +
                '}';
    }

}
