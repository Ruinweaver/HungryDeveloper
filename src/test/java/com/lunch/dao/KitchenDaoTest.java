package com.lunch.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lunch.model.Ingredient;
import com.lunch.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


public class KitchenDaoTest {
  private KitchenDao dao;

  @Before
  public void setUp() throws Exception {
    dao = new KitchenDao();
    dao.setObjectMapper(new ObjectMapper());
  }

  @Test
  public void testRetrieveIngredientsList() throws IOException {
    List<Ingredient> ingredientList = dao.retrieveIngredientsList();
    assertNotNull(ingredientList);
    assertFalse(ingredientList.isEmpty());
    Ingredient ingredient = ingredientList.get(0);
    assertNotNull(ingredient);
    assertNotNull(ingredient.getTitle());
    assertFalse(ingredient.getTitle().isEmpty());
    assertNotNull(ingredient.getBestBefore());
    assertTrue(ingredient.getBestBefore() instanceof String);
    assertNotNull(ingredient.getBestBeforeDate());
    assertTrue(ingredient.getBestBeforeDate() instanceof LocalDate);
    assertNotNull(ingredient.getUseBy());
    assertNotNull(ingredient.getUseByDate());
    assertTrue(ingredient.getUseByDate() instanceof LocalDate);
  }

  @Test
  public void testRecipeList() throws IOException {
    List<Recipe> recipeList = dao.retrieveRecipeList();
    assertNotNull(recipeList);
    assertFalse(recipeList.isEmpty());
    Recipe recipe = recipeList.get(0);
    assertNotNull(recipe);
    assertNotNull(recipe.getTitle());
    assertNotNull(recipe.getIngredients());
    assertFalse(recipe.getIngredients().isEmpty());
  }
}
