package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class SpecificationsTest {

  @Test
  void shouldCreateSpecifications(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Specifications.class));
  }

  @Test
  void shouldBuildSpecifications(){
    Assertions.assertNotNull(Specifications.builder().build());
  }
}
