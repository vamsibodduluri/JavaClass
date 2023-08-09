package com.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.products.entity.Product;
import com.products.service.ProductService;

@RestController
public class ProductsController {

	@Autowired
	ProductService productService;

	@GetMapping("/test")
	public String greet() {
		return "hello";
	}

	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product) {
		Product response = productService.saveProductInfo(product);
		return response;
	}

	@PutMapping("/updateProductInfo")
	public Product updateproductInfo(@RequestBody Product product) {
		Product response = productService.updateProductInfo(product);
		return response;
	}

	@GetMapping("/productInfo/{id}")
	public Product getProductInfo(@PathVariable Integer id) {
		return productService.getProductFromDB(id);
	}

	@DeleteMapping("/delteProductById/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		return productService.deleteProductFromDB(id);
	}

	@GetMapping("/allProduts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

}
