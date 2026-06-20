package com.example.product_api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ApplicationTests {
  @Autowired
  private ApplicationContext applicationContext;

  @Test
  void contextLoadsAndAppStarts() {
    Assertions.assertNotNull(applicationContext);
  }

}
