package com.product.Product.service;

import com.product.Product.entity.Product;
import com.product.Product.error.TitleNotFoundException;
import com.product.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProductList() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> fetchProductListByCategory(String category) {
        return productRepository.findProductByCategory(category);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> fetchProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product prodDB = productRepository.findById(id).get();
        if (Objects.nonNull(product.getTitle()) && !"".equalsIgnoreCase(product.getTitle())){
            prodDB.setTitle(product.getTitle());
        }
        if (Objects.nonNull(product.getDescription()) && !"".equalsIgnoreCase(product.getDescription())){
            prodDB.setDescription(product.getDescription());
        }
        if (Objects.nonNull(product.getCategory()) && !"".equalsIgnoreCase(product.getCategory())){
            prodDB.setCategory(product.getCategory());
        }

        return productRepository.save(prodDB);
    }

}
