package com.yesh.kardex.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Compra")
public class Purchase implements Serializable {
	
private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "FK_Cliente", nullable = false)
    @ManyToOne(optional = false,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Client cliente;
    @OneToOne
    @JoinColumn(name = "FK_Pago", updatable = false, nullable = false)
    private Payment payment;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha")
    private Date date;
    
    public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", pago='" + payment + '\'' +
                ", Fecha='" + date + '\'' +
                '}';
    }
}
