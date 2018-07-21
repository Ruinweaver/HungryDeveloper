package com.lunch.service;

import com.lunch.model.Ingredient;
import com.lunch.model.Recipe;
import com.lunch.model.RecipeComparator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JavaDeveloperService {
  @Autowired private KitchenService kitchenService;

  /**
   * Parse and return a date regardless of null or not.
   *
   * @param dateToParse The string date to parse
   * @return LocalDate non null always
   * @throws DateTimeParseException Date cannot be parsed so bye bye
   */
  public LocalDate parseDate(String dateToParse) throws DateTimeParseException {
    return Optional.ofNullable(dateToParse)
        .map((dateString) -> LocalDate.parse(dateString))
        .orElse(LocalDate.now());
  }

  /**
   * Find a yummy recipe to feed a hungry Java Developer. Given all the recipes, and all the
   * available ingredients. Check if all the ingredients are available and not expired. Then sort
   * them for the recipes with all available ingredients at the top of the result and recipes with
   * expiring ingredients to the bottom
   *
   * @param dateToCheck The local date to check requires non null
   * @return Reduced list of recipes with available ingredients
   * @throws IOException Any issues retrieving and manipulating the data
   */
  public List<Recipe> findMeRecipesImHungry(final LocalDate dateToCheck) throws IOException {
    Objects.requireNonNull(dateToCheck);

    final List<Recipe> allRecipes = kitchenService.retrieveRecipeList();

    final Map<String, Ingredient> availableIngredients =
        kitchenService.availableIngredients(dateToCheck);

    // get the set for convenience and just do it once
    final Set<String> availableIngredientNames = availableIngredients.keySet();

    final RecipeComparator comparator = new RecipeComparator(dateToCheck, availableIngredients);

    return allRecipes
        .stream()
        .filter((recipe) -> (availableIngredientNames.containsAll(recipe.getIngredients())))
        .sorted(comparator)
        .collect(Collectors.toList());
  }
}
