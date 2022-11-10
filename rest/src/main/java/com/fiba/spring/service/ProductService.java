package com.fiba.spring.service;

import java.util.List;
import com.fiba.spring.Product;

public interface ProductService {

	Product find(long productId);
	List<Product> findAll();
	void createProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(long productId);
}
