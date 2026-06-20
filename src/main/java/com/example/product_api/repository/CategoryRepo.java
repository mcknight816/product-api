package com.example.product_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.product_api.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends MongoRepository<Category, String> {
}