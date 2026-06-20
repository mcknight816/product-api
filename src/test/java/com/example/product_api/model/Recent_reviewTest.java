package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class Recent_reviewTest {

  @Test
  void shouldCreateRecent_review(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Recent_review.class));
  }

  @Test
  void shouldBuildRecent_review(){
    Assertions.assertNotNull(Recent_review.builder().build());
  }
}
