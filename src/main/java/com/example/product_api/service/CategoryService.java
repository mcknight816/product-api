package com.example.product_api.service;

import com.example.product_api.model.Category;
import com.example.product_api.repository.CategoryRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class CategoryService{

  private final CategoryRepo repo;

  public CategoryService(CategoryRepo repo) {
    this.repo = repo;
  }

  public  Category save(Category item) {
    return repo.save(item);
  }

  public void deleteById(String id) {
      repo.deleteById(id);
  }

  public Optional<Category> findById(String id) {
    return repo.findById(id);
  }

  public Iterable<Category> findAll() {
    return repo.findAll();
  }

  public Page<Category> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
