package com.ecommerce.shoppro.dto;

import java.math.BigDecimal;

public class CartItemDTO {
	private Long Id;
	private String productName;
	private int quantity;
	private BigDecimal price;
	public CartItemDTO(Long id, String productName, int quantity, BigDecimal price) {
		super();
		Id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
