package com.yesh.kardex.dto;

import java.sql.Blob;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDTO {

	// Atributos
	@NotNull
    @NotEmpty
    private Long id;
	@NotNull
    @NotEmpty
    private String name;
	@NotNull
    @NotEmpty
    private String code;
	@NotEmpty
    private Blob img;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @NotEmpty
    private Long quantity;
    @NotNull
    @NotEmpty
    private Long price;
    
    // Constructor
    public ProductDTO() {
    }

    public ProductDTO(String name, String code, Blob img, String description, Long quantity, Long price) {
		super();
		this.name = name;
		this.code = code;
		this.img = img;
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
    
    public Blob getIMG() {
        return img;
    }

    public void setIMG(Blob img) {
        this.img = img;
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
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", codigo='" + code + '\'' +
                ", descripcion='" + description + '\'' +
                ", existencias=" + quantity +
                ", precio=" + price +
                '}';
    }

}
