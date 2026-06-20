package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class DimensionsTest {

  @Test
  void shouldCreateDimensions(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Dimensions.class));
  }

  @Test
  void shouldBuildDimensions(){
    Assertions.assertNotNull(Dimensions.builder().build());
  }
}
