package com.infortech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;

	@Column(unique = true, nullable = false)
	private String productName;

	@Column(nullable = false)
	private int productQTY;

	@Column(nullable = false)
	private double productPrice;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product( long productId, String productName, int productQTY, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQTY() {
		return productQTY;
	}

	public void setProductQTY(int productQTY) {
		this.productQTY = productQTY;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
