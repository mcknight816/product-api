package com.example.product_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.product_api.model.Image;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends MongoRepository<Image, String> {
}