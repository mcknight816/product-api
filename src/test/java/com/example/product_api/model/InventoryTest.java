package com.example.product_api.model;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

@Scope("test")
class InventoryTest {

  @Test
  void shouldCreateInventory(){
    EasyRandom generator = new EasyRandom();
    Assertions.assertNotNull(generator.nextObject(Inventory.class));
  }

  @Test
  void shouldBuildInventory(){
    Assertions.assertNotNull(Inventory.builder().build());
  }
}
