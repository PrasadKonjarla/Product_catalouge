package com.example.Product_Catalogue.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product_Catalogue.Entity.Product;
import com.example.Product_Catalogue.Service.ProductServiceImp;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductServiceImp productServiceImp;

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> searchProduct(@RequestParam long productId) {
		Product resultProduct = productServiceImp.searchProduct(productId);
		return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product Resultproduct = productServiceImp.addProduct(product);
		return new ResponseEntity<Product>(Resultproduct, HttpStatus.CREATED);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @RequestParam long productId)
			throws Exception {
		Product resultProduct = productServiceImp.updateProduct(product, productId);
		return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteProduct(@RequestParam long productId) {
		productServiceImp.deleteProduct(productId);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
