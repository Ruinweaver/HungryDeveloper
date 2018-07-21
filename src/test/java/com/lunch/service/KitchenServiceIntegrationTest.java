package com.lunch.service;

import com.lunch.model.Ingredient;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KitchenServiceIntegrationTest {

  @Autowired private KitchenService kitchenService;

  /**
   * Test the available ingredients service with the real data.
   *
   * @throws IOException parse exceptions
   */
  @Test
  public void availableIngredient() throws IOException {
    assertNotNull(kitchenService);
    Map<String, Ingredient> availableIngredients =
        kitchenService.availableIngredients(LocalDate.parse("2018-03-03"));
    assertNotNull(availableIngredients);
    assertFalse(availableIngredients.isEmpty());
  }
}
