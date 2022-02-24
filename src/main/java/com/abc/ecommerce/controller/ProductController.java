package com.abc.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecommerce.entity.Producttb;
import com.abc.ecommerce.service.ProductService;


@RestController
@RequestMapping("/product")     //When @RequestMapping is used on class level it creates a base URI for which the controller will be used. 
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Producttb> addProduct(@RequestBody Producttb product) {
		
		logger.debug("Product Controller - Add Product Called");
		
		Producttb newProduct = productService.saveProduct(product);
		
		ResponseEntity<Producttb> responseEntity = new ResponseEntity<>(newProduct,HttpStatus.CREATED);
		
		logger.info("New Product is saved with Id : ");
		
		logger.debug("Product Controller - Add Product Called");

		return responseEntity;		
		
	}
	
	
	@GetMapping("/all")
	public List<Producttb> fetchAllProducts() {
		
		List<Producttb> products = productService.getAllProducts();
		
		return products;
	}
	
	@GetMapping("/get/{pid}")
	public ResponseEntity<?> fetchProductDetails(@PathVariable("pid") int productId) {
		Producttb product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping("/getbyname/{pname}")
	public ResponseEntity<?> fetchProductDetailsByNane(@PathVariable("pname") String pname) {
		Producttb product = productService.getProductByName(pname);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> deleteProduct(@PathVariable("pid") int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>("Product Deleted with id: "+productId, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Producttb> modifyProduct(@RequestBody Producttb product) {
		Producttb updatedProduct = productService.updateProduct(product);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
}