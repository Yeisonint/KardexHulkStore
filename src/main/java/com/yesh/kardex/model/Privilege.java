package com.yesh.kardex.model;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "Privilegios")
public class Privilege {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Nombre")
    private String name;

    @ManyToMany(mappedBy = "privileges",fetch = FetchType.EAGER)
    private Collection<Role> roles;
    
    public Privilege() {
    	
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Privilege(String name) {
		super();
		this.name = name;
	}
	
	
}