package com.example.Product_Catalogue.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Product_Catalogue.Entity.Product;
import com.example.Product_Catalogue.Repo.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product searchProduct(long productId) {
		return productRepo.findById(productId).get();

	}

	@Override
	public Product updateProduct(Product product, long productId) throws Exception {

		Product actualProduct = productRepo.findById(productId).get();

		try {

			if (actualProduct.getProductName() != product.getProductName()) {
				actualProduct.setProductName(product.getProductName());
			}

			if (actualProduct.getProductDescription() != product.getProductDescription()) {
				actualProduct.setProductDescription(product.getProductDescription());
			}

			if (actualProduct.getProductPrice() != product.getProductPrice()) {
				actualProduct.setProductPrice(product.getProductPrice());
			}

		} catch (Exception e) {
			System.out.printf("ProductServiceImp.updateProduct()", e);
		}

		return productRepo.save(actualProduct);
	}

	@Override
	public void deleteProduct(long productId) {
		productRepo.deleteById(productId);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

}
