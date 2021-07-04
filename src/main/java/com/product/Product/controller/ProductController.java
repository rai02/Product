package com.product.Product.controller;

import com.product.Product.entity.Product;
import com.product.Product.error.ProductNotFoundException;
import com.product.Product.error.TitleNotFoundException;
import com.product.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

//            -> saveProduct (Endpoint: /products) [PostMapping] "DONE"
//
//            -> fetchProductList (Endpoint: /products) [GetMapping] "DONE"
//
//            -> fetchProductListByCategory (Endpoint: /products/category/{category}) [GetMapping] "Done"
//
//            -> deleteProduct (Endpoint: /products/{id}) [DeleteMapping] "DONE"
//
//            -> fetchProductById (Endpoint: /products/{id}) [GetMapping] "DONE"
//
//            -> updateProduct (Endpoint: /products) [UpdateMapping] "DONE"
//


    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) throws TitleNotFoundException {
        System.out.println(product);
        if(product.getTitle() == null){
            throw new TitleNotFoundException("title nahi hai re baba");
        }
        return productService.saveProduct(product);

    }

    @GetMapping("/products")
    public List<Product> fetchProductList(){
        return productService.fetchProductList();
    }

    @GetMapping("/products/category/{category}")
    public List<Product> fetchProductListByCategory(@PathVariable("category") String category){
        return productService.fetchProductListByCategory(category);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/products/{id}")
    public Optional<Product> fetchProductById(@PathVariable("id") Long id){
        return productService.fetchProductById(id);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @Valid @RequestBody Product product){
        return productService.updateProduct(id, product);
    }
}
