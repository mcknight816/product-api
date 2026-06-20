package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class ShippingTest {

  @Test
  void shouldCreateShipping(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Shipping.class));
  }

  @Test
  void shouldBuildShipping(){
    Assertions.assertNotNull(Shipping.builder().build());
  }
}
