package com.product.Product.service;

import com.product.Product.entity.Product;
import com.product.Product.error.TitleNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> fetchProductList();

    public List<Product> fetchProductListByCategory(String category);

    public void deleteProductById(Long id);


    public Optional<Product> fetchProductById(Long id);

    public Product updateProduct(Long id, Product product);
}
