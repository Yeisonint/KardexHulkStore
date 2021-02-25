package com.yesh.kardex.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "DetallesCompra")
public class PurchaseDetail implements Serializable {
	
private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Product product;
    @OneToOne
    @JoinColumn(name = "FK_Compra", updatable = false, nullable = false)
    private Purchase purchase;

}
