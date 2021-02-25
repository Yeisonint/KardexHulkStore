package com.yesh.kardex.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Nombre")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Clave")
    private String password;

	public Client() {
	}
	
	public Client(String name,String email,String password) {
		setName(name);
		setEmail(email);
		setPassword(password);
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
                ", nombre='" + name + '\'' +
                ", correo='" + email + '\'' +
                ", clave='" + password + '\'' +
                '}';
    }

}
