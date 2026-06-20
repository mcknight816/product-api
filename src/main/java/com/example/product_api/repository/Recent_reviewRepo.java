package com.example.product_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.product_api.model.Recent_review;
import org.springframework.stereotype.Repository;

@Repository
public interface Recent_reviewRepo extends MongoRepository<Recent_review, String> {
}