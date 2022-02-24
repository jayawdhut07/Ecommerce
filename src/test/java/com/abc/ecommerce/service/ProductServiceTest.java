package com.abc.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecommerce.entity.Producttb;
import com.abc.ecommerce.exception.ProductNotFoundException;
import com.abc.ecommerce.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {
//	
//	@Test
//	public void sampleTest() {
//		
//		assertTrue(true);
//	}

	@InjectMocks
	private ProductService productService = new ProductServiceImpl();
	
	@Mock
	private ProductRepository productRepository;
	@Test
    public void testSaveProduct() {
       
        Producttb product = new Producttb();
        product.setProductId(10);
        product.setProductName("dummyname");
        product.setPrice(11111);
        product.setCreatedAt(LocalDate.of(2000, 10, 10));
  
       
        when(productRepository.save(product)).thenReturn(product);
       
        Producttb newProduct = productService.saveProduct(product);
       
        //assertEquals(product.getProductName(), newProduct.getProductName());
       
        verify(productRepository,times(1)).save(product);       
       
    }
	
	@Test
    public void testGetProductByIdNotFound() {
       
        int productId = 200;       
           
        when(productRepository.findById(productId)).thenThrow(ProductNotFoundException.class);
           
        assertThrows(ProductNotFoundException.class,()->productService.getProductById(productId));
       
    }
	
	@Test
    public void deleteProductById() {
       
        int productId = 222;
       
        Producttb product = new Producttb();
        product.setProductId(222);
        product.setProductName("dummyname");
        product.setPrice(11111);
        product.setCreatedAt(LocalDate.of(2000, 10, 10));
       
        Optional<Producttb> optionalProduct = Optional.of(product);
       
        when(productRepository.findById(222)).thenReturn(optionalProduct);   
           
        productService.deleteProduct(product.getProductId());
       
        verify(productRepository,times(1)).deleteById(productId);   
       
        //doNothing().when(productRepository).deleteById(product.getProductId());
       
    }

}
