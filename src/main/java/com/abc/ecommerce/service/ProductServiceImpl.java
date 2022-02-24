package com.abc.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecommerce.entity.Producttb;
import com.abc.ecommerce.exception.ProductNotFoundException;
import com.abc.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Producttb saveProduct(Producttb  product) {
	    
		Producttb savedProduct = productRepository.save(product);
			
		return savedProduct;
	}

	@Override
	public List<Producttb> getAllProducts() {
		List<Producttb> products = productRepository.findAll();
		return products;
	}

	
	@Override
	public Producttb getProductById(int productId) {
		Producttb product = null;
		Optional<Producttb> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return product;
		}
		
	
	}

	@Override
	public Producttb getProductByName(String productName) {
		Producttb product = productRepository.findByProductName(productName);
		return product;
	}
	
	
	@Override
	public Producttb updateProduct(Producttb product) {
Optional<Producttb> optionalProduct = productRepository.findById(product.getProductId());
		
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Sorry! Product is not existing with id: "+product.getProductId());
		}
		
		Producttb updatedProduct = productRepository.save(product);
		
		return updatedProduct;
	}
	

	@Override
	public void deleteProduct(int productId) {
        Optional<Producttb> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isPresent()) {			
			productRepository.deleteById(productId);			
		}
		else {
			throw new ProductNotFoundException("Sorry! Product is not existing with id: "+productId);
		}			
	}


	}
	
	