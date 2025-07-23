package com.ecommerce.shoppro.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderResponse {
	private Long id;
	private BigDecimal totalAmount;
	private String status;
	private LocalDateTime createdAt;
	
	public OrderResponse(Long id, BigDecimal totalAmount, String status, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.totalAmount = totalAmount;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	

}
