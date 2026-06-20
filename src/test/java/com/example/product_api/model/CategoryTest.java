package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class CategoryTest {

  @Test
  void shouldCreateCategory(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Category.class));
  }

  @Test
  void shouldBuildCategory(){
    Assertions.assertNotNull(Category.builder().build());
  }
}
