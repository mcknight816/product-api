package com.example.product_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.product_api.model.Variant;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepo extends MongoRepository<Variant, String> {
}