package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class SeoTest {

  @Test
  void shouldCreateSeo(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Seo.class));
  }

  @Test
  void shouldBuildSeo(){
    Assertions.assertNotNull(Seo.builder().build());
  }
}
