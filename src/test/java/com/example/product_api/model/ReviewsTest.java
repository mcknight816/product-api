package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class ReviewsTest {

  @Test
  void shouldCreateReviews(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Reviews.class));
  }

  @Test
  void shouldBuildReviews(){
    Assertions.assertNotNull(Reviews.builder().build());
  }
}
