package com.yesh.kardex.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pago")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@Column(name = "Valor", nullable = false, updatable = false)
    private long amount;

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", valor='" + amount +
                '}';
    }
}
