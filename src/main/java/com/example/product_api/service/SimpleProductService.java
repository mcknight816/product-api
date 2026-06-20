package com.example.product_api.service;

import com.example.product_api.model.SimpleProduct;
import com.example.product_api.repository.SimpleProductRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class SimpleProductService{

  private final SimpleProductRepo repo;

  public SimpleProductService(SimpleProductRepo repo) {
    this.repo = repo;
  }

  public  SimpleProduct save(SimpleProduct item) {
    return repo.save(item);
  }

  public void deleteById(String id) {
      repo.deleteById(id);
  }

  public Optional<SimpleProduct> findById(String id) {
    return repo.findById(id);
  }

  public Iterable<SimpleProduct> findAll() {
    return repo.findAll();
  }

  public Page<SimpleProduct> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
