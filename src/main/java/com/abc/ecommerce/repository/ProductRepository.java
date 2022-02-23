package com.abc.ecommerce.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.ecommerce.entity.Producttb;


//@Repository

public interface ProductRepository extends JpaRepository<Producttb,Integer> {	
	
public Producttb findByProductName(String productName);
	
//	@Query("Select p from Product p where p.productCategory = :pcategory")
//	public List<Producttb> findProductByCategory(@Param("pcategory") String category);
//	
	
}



