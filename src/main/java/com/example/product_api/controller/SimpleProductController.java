package com.example.product_api.controller;

import com.example.product_api.model.SimpleProduct;
import com.example.product_api.dto.SimpleProductDto;
import com.example.product_api.mapping.SimpleProductMapper;
import com.example.product_api.service.SimpleProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class SimpleProductController {

  private final SimpleProductService service;

  public SimpleProductController(SimpleProductService service) {
    this.service = service;
  }

  @PostMapping(value="/simpleProduct",produces = MediaType.APPLICATION_JSON_VALUE)
  public SimpleProductDto save(@RequestBody SimpleProductDto dto){
        return SimpleProductMapper.MAPPER.simpleProductToSimpleProductDto(this.service.save(SimpleProductMapper.MAPPER.simpleProductDtoToSimpleProduct(dto)));
  }

  @GetMapping(value = "/simpleProduct/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<SimpleProductDto> findById(@PathVariable("id") String id ){
    return this.service.findById(String.valueOf(id)).map(SimpleProductMapper.MAPPER::simpleProductToSimpleProductDto);
  }

  @GetMapping(value = "/simpleProduct",produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<SimpleProductDto> findAll(){
    return StreamSupport.stream(this.service.findAll().spliterator(),true)
        .map(SimpleProductMapper.MAPPER::simpleProductToSimpleProductDto).collect(Collectors.toList());
  }

  @DeleteMapping(value = "/simpleProduct/{id}")
  public void deleteById(@PathVariable("id") String id ){
   this.service.deleteById(String.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/simpleProduct/search"}, produces = { "application/json" })
  public Page<SimpleProduct> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
    return this.service.search(searchTerm,PageRequest.of(page,limit));
  }
}
