package com.lunch.service;

import com.lunch.dao.KitchenDao;
import com.lunch.model.Ingredient;
import com.lunch.model.Recipe;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A service for all kitchen related tasks like accessing the fridge and cupboards as well as
 * getting the recipe books.
 */
@Service
public class KitchenService {

  @Autowired private KitchenDao kitchenDao;

  /**
   * Retrieve all ingredients regardless of expired.
   *
   * @return List of ingredients
   * @throws IOException parsing issues
   */
  public List<Ingredient> allIngredients() throws IOException {
    return kitchenDao.retrieveIngredientsList();
  }

  /**
   * Retrieve the available ingredients for a date.
   *
   * @param dateToCheck Mandatory
   * @return Map of the ingredient title to the available ingredient
   * @throws IOException parsing issues
   */
  public Map<String, Ingredient> availableIngredients(LocalDate dateToCheck) throws IOException {
    Objects.requireNonNull(dateToCheck);
    return kitchenDao
        .retrieveIngredientsList()
        .stream()
        .filter(
            (ingredient) ->
                (dateToCheck.isBefore(ingredient.getUseByDate())
                    || dateToCheck.equals(ingredient.getUseByDate())))
        .collect(Collectors.toUnmodifiableMap(Ingredient::getTitle, Function.identity()));
  }

  /**
   * Retrieve a list of recipes.
   *
   * @return list of recipies
   * @throws IOException parsing issues
   */
  public List<Recipe> retrieveRecipeList() throws IOException {
    return kitchenDao.retrieveRecipeList();
  }

  public void setKitchenDao(KitchenDao kitchenDao) {
    this.kitchenDao = kitchenDao;
  }
}
