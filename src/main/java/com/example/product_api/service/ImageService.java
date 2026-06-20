package com.example.product_api.service;

import com.example.product_api.model.Image;
import com.example.product_api.repository.ImageRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class ImageService{

  private final ImageRepo repo;

  public ImageService(ImageRepo repo) {
    this.repo = repo;
  }

  public  Image save(Image item) {
    return repo.save(item);
  }

  public void deleteById(String id) {
      repo.deleteById(id);
  }

  public Optional<Image> findById(String id) {
    return repo.findById(id);
  }

  public Iterable<Image> findAll() {
    return repo.findAll();
  }

  public Page<Image> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAll(pageable);
  }
}
