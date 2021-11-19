package com.lti.IMS.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.IMS.Exception.ResourceNotFoundException;
import com.lti.IMS.Model.Product;
import com.lti.IMS.dao.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productrep;
	
	public LocalDate CalculateExpiryDate( long productid) throws ResourceNotFoundException{
		Product prod=productrep.findById(productid)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + productid));
		
		LocalDate dt=prod.getMfd();
		LocalDate exp = dt.plusMonths(prod.getUsebefore());
		productrep.setExpiry(exp,productid);
		return exp;
	}
	
	public Product CreateProduct(Product product) {
		return productrep.save(product);
	}
	public List<Product> SortProducts(){
		
		return productrep.sortByExpiryDate();
		
	}
	
public void RemoveExpiry() {
		List<Product> prod=productrep.findAll();
		LocalDate today=LocalDate.now();
		List<Product> filteredlist=prod.stream().filter(p->p.getExpiry().isBefore(today)).collect(Collectors.toList());
		for(Product p: filteredlist) {
			productrep.delete(p);
		}
		
	}

public void ApplyDiscounts() {
	List<Product> prod=productrep.findAll();
	LocalDate today=LocalDate.now();
	for(Product p: prod) {
		if(ChronoUnit.MONTHS.between(p.getExpiry(), today)<6) {
			productrep.Discount(p.getId());
		}
	}
}

public Optional<Product> Search(long productid) {
	
	return productrep.findById( productid);
}


}
