package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class ColorTest {

  @Test
  void shouldCreateColor(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Color.class));
  }

  @Test
  void shouldBuildColor(){
    Assertions.assertNotNull(Color.builder().build());
  }
}
