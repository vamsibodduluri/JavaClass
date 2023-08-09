package com.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.entity.Product;
import com.products.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository prodRepository;

	public Product saveProductInfo(Product product) {
		Product response = prodRepository.save(product);
		return response;
	}

	public Product updateProductInfo(Product product) {
		Product response = null;
		Optional<Product> productFromDb = prodRepository.findById(product.getId());
		if (productFromDb != null && productFromDb.isPresent()) {
			response = prodRepository.save(product);
		} else {
			response = prodRepository.save(product);
		}
		return response;
	}

	public Product getProductFromDB(Integer id) {
		Optional<Product> response = prodRepository.findById(id);
		return response.get();
	}

	public String deleteProductFromDB(Integer id) {
		prodRepository.deleteById(id);
		return "Product was Deleted Successfully";
	}

	public List<Product> getAllProducts() {
		List<Product> response = prodRepository.findAll();
		return response;
	}

}
