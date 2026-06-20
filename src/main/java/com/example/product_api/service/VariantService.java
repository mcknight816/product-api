package com.example.product_api.service;

import com.example.product_api.model.Variant;
import com.example.product_api.repository.VariantRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class VariantService{

  private final VariantRepo repo;

  public VariantService(VariantRepo repo) {
    this.repo = repo;
  }

  public  Variant save(Variant item) {
    return repo.save(item);
  }

  public void deleteById(String id) {
      repo.deleteById(id);
  }

  public Optional<Variant> findById(String id) {
    return repo.findById(id);
  }

  public Iterable<Variant> findAll() {
    return repo.findAll();
  }

  public Page<Variant> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
