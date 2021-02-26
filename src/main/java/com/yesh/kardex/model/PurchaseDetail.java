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
    @JoinColumn(name = "FK_Producto", updatable = false, nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Product product;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_Compra", updatable = false, nullable = false)
    private Purchase purchase;
    @Column(name = "Cantidad")
    private long quantity;
    @Column(name = "Total")
    private String total;
    
    public PurchaseDetail() {
    	
    }
    
    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", producto='" + product + '\'' +
                ", compra='" + purchase + '\'' +
                ", cantidad='" + quantity + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
