package com.lti.IMS.dao;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.IMS.Model.Product;
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long>{

	
	 
	@Query(value = "select c from Product c ORDER BY expiry")
	List<Product> sortByExpiryDate();
	
	@Modifying
	@Query(value="update Product p SET p.price=(p.price-(p.price*0.2))  where p.id= ?1")
	void Discount( long l);

	@Modifying
	@Query(value="update Product p SET p.expiry= ?1 where p.id= ?2")
	void setExpiry(LocalDate exp, long productid);
}


