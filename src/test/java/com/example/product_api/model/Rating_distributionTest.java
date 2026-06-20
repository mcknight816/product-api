package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class Rating_distributionTest {

  @Test
  void shouldCreateRating_distribution(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Rating_distribution.class));
  }

  @Test
  void shouldBuildRating_distribution(){
    Assertions.assertNotNull(Rating_distribution.builder().build());
  }
}
