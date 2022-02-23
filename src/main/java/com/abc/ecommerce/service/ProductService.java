package com.abc.ecommerce.service;

import java.util.List;

import com.abc.ecommerce.entity.Producttb;

public interface ProductService {

	public Producttb saveProduct(Producttb product);
	
    public List<Producttb> getAllProducts() ;
	
	public Producttb getProductById(int productId);
	
	public Producttb getProductByName(String productName);
	
	public Producttb updateProduct(Producttb product);
	
	public void deleteProduct(int productId);

	
}