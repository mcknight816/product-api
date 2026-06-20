package com.example.product_api.service;

import com.example.product_api.model.Recent_review;
import com.example.product_api.repository.Recent_reviewRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class Recent_reviewService{

  private final Recent_reviewRepo repo;

  public Recent_reviewService(Recent_reviewRepo repo) {
    this.repo = repo;
  }

  public  Recent_review save(Recent_review item) {
    return repo.save(item);
  }

  public void deleteById(String id) {
      repo.deleteById(id);
  }

  public Optional<Recent_review> findById(String id) {
    return repo.findById(id);
  }

  public Iterable<Recent_review> findAll() {
    return repo.findAll();
  }

  public Page<Recent_review> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
