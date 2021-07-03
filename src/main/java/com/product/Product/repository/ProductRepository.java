package com.product.Product.repository;

import com.product.Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findProductByCategory(String category);
}
