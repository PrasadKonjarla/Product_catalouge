package com.example.Product_Catalogue.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Product_Catalogue.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
