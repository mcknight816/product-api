package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class VariantTest {

  @Test
  void shouldCreateVariant(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Variant.class));
  }

  @Test
  void shouldBuildVariant(){
    Assertions.assertNotNull(Variant.builder().build());
  }
}
