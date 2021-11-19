package com.lti.IMS.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.IMS.Exception.ResourceNotFoundException;
import com.lti.IMS.Model.Product;
import com.lti.IMS.Service.ProductService;
import com.lti.IMS.dao.ProductRepository;


@RestController
@RequestMapping("/inventory")
public class ProductController {

	@Autowired
	ProductService ProdSer;
	
	@PostMapping("/product")
	public Product CreateProduct(@RequestBody Product product) {
		return ProdSer.CreateProduct(product);
	}
	
	@PutMapping("/product/{id}")
	public LocalDate CalculateExpiryDate(@PathVariable(value = "id") long productid) throws ResourceNotFoundException{
		LocalDate exp = ProdSer.CalculateExpiryDate(productid);
		return exp;
	}
	
	@PutMapping("/removeproduct")
	public String RemoveExpiry() {
		
		ProdSer.RemoveExpiry();
		return "Successful";
	}
	
	@PutMapping("/sortproduct")
	public List<Product> SortProducts() {
		return ProdSer.SortProducts();
		
	}
	
	@GetMapping("SearchProduct/{id}")
	public Optional<Product> SearchProduct(@PathVariable(value = "id") long productid) {
		return ProdSer.Search(productid);
	}
}
