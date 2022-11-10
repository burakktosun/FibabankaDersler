package com.fiba2.spring.entity;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/inventory")
public class ProductController {
	
	//@Autowired
	private ProductRepository productRepository; 
	
	public ProductController (ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	@GetMapping("/product/insert")
	@ResponseBody
	public String insertProduct() {
		Product product = new Product();
		product.setProductName("Cep Telefonu");
		product.setSalesPrice(5541);
		productRepository.save(product);
		return "Sokuldu : " +product.getProductId();
	}
	@GetMapping("/product/find")
	@ResponseBody
	public String findProduct() {
		long productId=1;
		
		Optional<Product> optional= productRepository.findById(productId);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			System.out.println(product.getProductId()+" "
					+product.getProductName()+" "
					+product.getSalesPrice());
		
		return "Ürün bulundu : " +product.getProductId();
		}
	
	return "Ürün bulunamadı ";
	}
	@GetMapping("/product/list")
	@ResponseBody
	public String listProducts() {
		Iterable<Product> products = productRepository.findAll();
		int count=0;
		for(Product product : products) {
			System.out.println(product.getProductId()+ " " 
						+product.getProductName()+" "
						+ product.getSalesPrice());
			count++;
		}return "Ürün sayısı " + count;
	}
	@GetMapping("/product/expensives")
	@ResponseBody
	public String listExpensivesProducts() {
		double minPrice=1200; 
		Iterable<Product> products = productRepository.findAllBySalesPriceMin(minPrice);
		int count=0;
		for(Product product : products) {
			System.out.println(product.getProductId()+ " " +product.getProductName()+" "+ product.getSalesPrice());
			count++;
		}return "Ürün sayısı " +count;
	}
	@GetMapping("product/delete")
	@ResponseBody
	public String deleteProducts() {
		long productId=3;
		if(!productRepository.existsById(productId)) {
			return "Bulunamadı " + productId;
		}
		productRepository.deleteById(productId);
		return "Silindi ";
}
}