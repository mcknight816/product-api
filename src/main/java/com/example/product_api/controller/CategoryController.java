package com.example.product_api.controller;

import com.example.product_api.model.Category;
import com.example.product_api.dto.CategoryDto;
import com.example.product_api.mapping.CategoryMapper;
import com.example.product_api.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class CategoryController {

  private final CategoryService service;

  public CategoryController(CategoryService service) {
    this.service = service;
  }

  @PostMapping(value="/category",produces = MediaType.APPLICATION_JSON_VALUE)
  public CategoryDto save(@RequestBody CategoryDto dto){
        return CategoryMapper.MAPPER.categoryToCategoryDto(this.service.save(CategoryMapper.MAPPER.categoryDtoToCategory(dto)));
  }

  @GetMapping(value = "/category/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<CategoryDto> findById(@PathVariable("id") String id ){
    return this.service.findById(String.valueOf(id)).map(CategoryMapper.MAPPER::categoryToCategoryDto);
  }

  @GetMapping(value = "/category",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<CategoryDto> findAll(){
    return StreamSupport.stream(this.service.findAll().spliterator(),true)
        .map(CategoryMapper.MAPPER::categoryToCategoryDto).collect(Collectors.toList());
  }

  @DeleteMapping(value = "/category/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(String.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/category/search"}, produces = { "application/json" })
  public Page<Category> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
