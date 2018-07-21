package com.lunch.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class RecipeComparator implements Comparator<Recipe> {

  private Map<String, Ingredient> availableIngredients;
  private LocalDate dateToCheck;

  /**
   * A Comparator to sort the recipes by available ingredients. Order the recipe with all
   * ingredients at the top
   *
   * @param dateToCheck a date to check against to see if the ingredients are expiring.
   * @param availableIngredients The available ingredients as a map for speed
   */
  public RecipeComparator(LocalDate dateToCheck, Map<String, Ingredient> availableIngredients) {
    Objects.requireNonNull(availableIngredients);
    Objects.requireNonNull(dateToCheck);
    this.availableIngredients = availableIngredients;
    this.dateToCheck = dateToCheck;
  }

  /**
   * Assumption is the recipe has the ingredients if this comparator is used.
   *
   * @param o1 The recipe to evaluate
   * @param o2 Don't really use this one
   * @return int -1 Got higher in the list so Available, and 1 lower in the list not avail
   */
  @Override
  public int compare(Recipe o1, Recipe o2) {
    boolean containsExpiringIngredientSoon = false;

    for (String ingredientTitle : o1.getIngredients()) {
      Ingredient ingredient = availableIngredients.get(ingredientTitle);
      if (ingredient != null) { // just in case
        if (dateToCheck.isAfter(ingredient.getUseByDate())) {
          throw new IllegalArgumentException(
              String.format(
                  "The use by date %s should not be past %s",
                  this.dateToCheck.toString(), ingredient.getUseBy()));
        }
        if (dateToCheck.isAfter(ingredient.getBestBeforeDate())
            && (dateToCheck.isBefore(ingredient.getUseByDate())
                || dateToCheck.isEqual(ingredient.getUseByDate()))) {
          containsExpiringIngredientSoon = true;
          break;
        }
      } else {
        throw new IllegalArgumentException(
            String.format(
                "The ingredient %s is not available and already expiered", ingredientTitle));
      }
    }
    return (containsExpiringIngredientSoon ? 1 : -1);
  }
}
