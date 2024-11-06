package com.example.Product_Catalogue.Service;

import com.example.Product_Catalogue.Entity.Product;

public interface ProductService {

	Product searchProduct(long productId);

	Product updateProduct(Product product, long productId) throws Exception;

	void deleteProduct(long productId);

	Product addProduct(Product product);

}
