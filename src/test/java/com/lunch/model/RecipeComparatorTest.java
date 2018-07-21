package com.lunch.model;

import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;


public class RecipeComparatorTest {

  @Test
  public void testCompare_simple_available() {
    LocalDate testDate = LocalDate.parse("2018-02-02");
    Map<String, Ingredient> mockedAvailIngredients = new HashMap<>();
    mockedAvailIngredients.put("Cheese", new Ingredient("Cheese", "2018-07-16", "2018-07-21"));

    var mockedIngredient = new HashSet<String>();
    mockedIngredient.add("Cheese");

    Recipe mockedRecipe = new Recipe("Just Cheese", mockedIngredient);
    RecipeComparator comparator = new RecipeComparator(testDate, mockedAvailIngredients);

    int result = comparator.compare(mockedRecipe, mockedRecipe);

    assertTrue(result == -1);
  }

  @Test
  public void testCompare_simple_almost_expiring() {
    LocalDate testDate = LocalDate.parse("2018-07-17");
    Map<String, Ingredient> mockedAvailIngredients = new HashMap<>();
    mockedAvailIngredients.put("Cheese", new Ingredient("Cheese", "2018-07-16", "2018-07-21"));

    var mockedIngredient = new HashSet<String>();
    mockedIngredient.add("Cheese");

    Recipe mockedRecipe = new Recipe("Just Cheese", mockedIngredient);
    RecipeComparator comparator = new RecipeComparator(testDate, mockedAvailIngredients);

    int result = comparator.compare(mockedRecipe, mockedRecipe);

    assertTrue(result == 1);
  }

  /** As some ingredients are past the best before then they will go to the bottom so expect -1. */
  @Test
  public void testCompare_multi_some_expiring() {
    LocalDate testDate = LocalDate.parse("2018-07-17");
    Map<String, Ingredient> mockedAvailIngredients = new HashMap<>();
    mockedAvailIngredients.put("Toast", new Ingredient("Toast", "2018-08-16", "2018-08-21"));
    mockedAvailIngredients.put("Cheese", new Ingredient("Cheese", "2018-07-16", "2018-07-21"));

    var mockedIngredient = new HashSet<String>();
    mockedIngredient.add("Cheese");
    mockedIngredient.add("Toast");

    Recipe mockedRecipe = new Recipe("Just Cheese & Toast", mockedIngredient);
    RecipeComparator comparator = new RecipeComparator(testDate, mockedAvailIngredients);

    int result = comparator.compare(mockedRecipe, mockedRecipe);

    assertTrue(result == 1);
  }

    /** All ingredients are the best before then they will go to the top so expect .*/
    @Test
    public void testCompare_multi_all_ok() {
        LocalDate testDate = LocalDate.parse("2018-05-17");
        Map<String, Ingredient> mockedAvailIngredients = new HashMap<>();
        mockedAvailIngredients.put("Toast", new Ingredient("Toast", "2018-08-16", "2018-08-21"));
        mockedAvailIngredients.put("Cheese", new Ingredient("Cheese", "2018-07-16", "2018-07-21"));

        var mockedIngredient = new HashSet<String>();
        mockedIngredient.add("Cheese");
        mockedIngredient.add("Toast");

        Recipe mockedRecipe = new Recipe("Just Cheese & Toast", mockedIngredient);
        RecipeComparator comparator = new RecipeComparator(testDate, mockedAvailIngredients);

        int result = comparator.compare(mockedRecipe, mockedRecipe);

        assertTrue(result == -1);
    }


    @Test(expected = IllegalArgumentException.class)
  public void testCompare_simple_unavailable() {
    LocalDate testDate = LocalDate.parse("2018-02-02");
    Map<String, Ingredient> mockedAvailIngredients = new HashMap<>();

    var mockedIngredient = new HashSet<String>();
    mockedIngredient.add("Cheese");

    Recipe mockedRecipe = new Recipe("Just Cheese", mockedIngredient);
    RecipeComparator comparator = new RecipeComparator(testDate, mockedAvailIngredients);

    int result = comparator.compare(mockedRecipe, mockedRecipe);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCompare_simple_usedby_expired() {
    LocalDate testDate = LocalDate.parse("2017-02-02");
    Map<String, Ingredient> mockedAvailIngredients = new HashMap<>();

    var mockedIngredient = new HashSet<String>();
    mockedIngredient.add("Cheese");

    Recipe mockedRecipe = new Recipe("Just Cheese", mockedIngredient);
    RecipeComparator comparator = new RecipeComparator(testDate, mockedAvailIngredients);

    int result = comparator.compare(mockedRecipe, mockedRecipe);
  }
}
