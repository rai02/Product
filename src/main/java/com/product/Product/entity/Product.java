package com.product.Product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    //    id -> product_id [long]
    //
    //    category -> product_category [string]
    //
    //    title -> product_title [string]
    //
    //    desc -> product_desc [string]
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @NotBlank(message = "This can't be blank, Give title ")
    private String title;

    private String description;

    @NotBlank(message = "This can't be blank, give category")
    private String category;
}
