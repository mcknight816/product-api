package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class SimpleProductTest {

  @Test
  void shouldCreateSimpleProduct(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(SimpleProduct.class));
  }

  @Test
  void shouldBuildSimpleProduct(){
    Assertions.assertNotNull(SimpleProduct.builder().build());
  }
}
