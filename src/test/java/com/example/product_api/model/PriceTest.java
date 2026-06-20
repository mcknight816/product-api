package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class PriceTest {

  @Test
  void shouldCreatePrice(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Price.class));
  }

  @Test
  void shouldBuildPrice(){
    Assertions.assertNotNull(Price.builder().build());
  }
}
