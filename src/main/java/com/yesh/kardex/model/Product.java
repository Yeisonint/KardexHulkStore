package com.yesh.kardex.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;


@Entity
@Table(name = "Producto")
public class Product implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private long id;
    @Column(name = "Nombre")
    private String name;
    @Column(name = "Codigo")
    private String code;
    @Column(name = "Descripcion")
    private String description;
    @Column(name = "Existencias")
    private Long quantity;
    @Column(name = "Precio")
    private Long price;
    
    public Product() {
    	
    }
    
    public Product(String name, String code, String description, Long quantity, Long price) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigo='" + code + '\'' +
                ", descripcion='" + description + '\'' +
                ", existencias=" + quantity +
                ", precio=" + price +
                '}';
    }

}