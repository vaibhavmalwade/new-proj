package com.lti.IMS.Model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column (name = "description", nullable = false)
	private String description;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String description, int qty, int price, LocalDate mfd, int usebefore, LocalDate expiry) {
		super();
		this.id = id;
		this.description = description;
		this.qty = qty;
		this.price = price;
		this.mfd = mfd;
		this.usebefore = usebefore;
		this.expiry = expiry;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", qty=" + qty + ", price=" + price + ", mfd="
				+ mfd + ", usebefore=" + usebefore + ", expiry=" + expiry + "]";
	}
	@Column(name = "quantity", nullable = false)
	private int qty;
	@Column(name = "price", nullable = false)
	private int price;
	@Column(name = "Manufactur_date", nullable = false)
	private LocalDate mfd;
	@Column(name = "Use_before", nullable = false)
	private long usebefore;
	@Column(name = "expiry_date", nullable = true)
	private LocalDate expiry;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	public long getUsebefore() {
		return usebefore;
	}
	public void setUsebefore(int usebefore) {
		this.usebefore = usebefore;
	}
	public LocalDate getExpiry() {
		return expiry;
	}
	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}
	
	
	
	
}
