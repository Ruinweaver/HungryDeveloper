package com.lunch.service;

import com.lunch.dao.KitchenDao;
import com.lunch.model.Ingredient;
import com.lunch.test.TestUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class KitchenServiceTest {

  @InjectMocks private KitchenService kitchenService;

  @Mock private KitchenDao kitchenDao;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Test available ingredients service that only returns available ingredients in a map.
   *
   * @throws IOException parse exceptions
   */
  @Test
  public void availableIngredients_simple() throws IOException {
    assertNotNull(kitchenService);

    when(kitchenDao.retrieveIngredientsList())
        .thenReturn(
            TestUtil.asList(
                Ingredient.class,
                new Ingredient("Test Available", "2020-10-10", "2020-12-10"),
                new Ingredient("Test Unavailable", "2018-01-09", "2018-01-10"),
                new Ingredient("Test Available Same Day", "2018-03-03", "2018-03-03"),
                new Ingredient("Test Unavailable Next Day", "2018-03-01", "2018-03-04"),
                new Ingredient("Test Available Previous Day", "2018-03-01", "2018-03-02")));

    Map<String, Ingredient> ingredientMap =
        kitchenService.availableIngredients(LocalDate.parse("2018-03-03"));
    assertNotNull(ingredientMap);
    assertFalse(ingredientMap.isEmpty());
    assertTrue(ingredientMap.size() == 3);

    Set<String> ingredientsKeys = ingredientMap.keySet();
    assertFalse(ingredientsKeys.stream().allMatch((key) -> (key.contains(" Available"))));
  }
}
