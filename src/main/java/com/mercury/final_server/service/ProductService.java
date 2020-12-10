package com.mercury.final_server.service;

import com.mercury.final_server.bean.Product;
import com.mercury.final_server.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product getOneProductById(long id) {
        return productDao.findById(id).orElse(new Product());
//        return productDao.findById(id).get();
    }

    public List<Product> getProductsAboveMinPrice(int minPrice) {
        // TODO: ask JPA to generate SQL with WHERE statement to search in DB
        return productDao.findByPriceGreaterThanEqual(minPrice);
    }

}
