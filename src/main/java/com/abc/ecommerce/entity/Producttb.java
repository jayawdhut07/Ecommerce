
package com.abc.ecommerce.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Producttb {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="product_id")
 private int productId;
	
@Column(name="product_name")
 private String productName;

@Column(name="price")
 private int price;

@Column(name="createdat")
 private LocalDate createdAt;

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}


public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public LocalDate getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(LocalDate createdAt) {
	this.createdAt = createdAt;
}

}