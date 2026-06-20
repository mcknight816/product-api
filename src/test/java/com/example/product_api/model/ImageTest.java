package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class ImageTest {

  @Test
  void shouldCreateImage(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Image.class));
  }

  @Test
  void shouldBuildImage(){
    Assertions.assertNotNull(Image.builder().build());
  }
}
