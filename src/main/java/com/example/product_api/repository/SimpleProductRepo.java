package com.example.product_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.product_api.model.SimpleProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleProductRepo extends MongoRepository<SimpleProduct, String> {
}