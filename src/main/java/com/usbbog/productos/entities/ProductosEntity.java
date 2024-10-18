package com.usbbog.productos.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductosEntity {
	
	private UUID id;
	private String productName;
	private Integer productStock;
	private Float productPrice;
	private Boolean productState;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductStock() {
		return productStock;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	public Boolean getProductState() {
		return productState;
	}
	public void setProductState(Boolean productState) {
		this.productState = productState;
	}
	
	public ProductosEntity(UUID id, String productName, Integer productStock, Float productPrice,
			Boolean productState) {
		super();
		this.id = id;
		this.productName = productName;
		this.productStock = productStock;
		this.productPrice = productPrice;
		this.productState = productState;
	}
	

}
