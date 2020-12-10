package com.mercury.final_server.controller;

import com.mercury.final_server.bean.Product;
import com.mercury.final_server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    // GET /products
    // GET /products?minPrice=400
    @GetMapping
    public List<Product> getProducts(@RequestParam(name = "minPrice", required = false) Integer minPrice) {
        if (minPrice != null) { // return products with price > minPrice
            return productService.getProductsAboveMinPrice(minPrice);
        }
        return productService.getAllProducts();
    }

    // GET /Products/2       find product by id
    @GetMapping("/{id}")   // {id} is path variable
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getOneProductById(id);
    }

}
