package com.lunch.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lunch.model.Ingredient;
import com.lunch.model.IngredientsDTO;
import com.lunch.model.Recipe;
import com.lunch.model.RecipesDTO;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** The Kichen DAO accesses all data for the kitchen. */
@Repository
public class KitchenDao {

  @Autowired private ObjectMapper objectMapper;

  /**
   * Retrieve a list of all Ingredients in the kitchen.
   *
   * @return list of Ingredients.
   * @throws IOException Any issues retreiving the list
   */
  public List<Ingredient> retrieveIngredientsList() throws IOException {
    try (InputStream inputStream = streamFile("/static/json/ingredients.json")) {
      IngredientsDTO ingredients = objectMapper.readValue(inputStream, IngredientsDTO.class);
      return ingredients.getIngredients();
    }
  }

  /**
   * Retrieve all the recipes in the kitchen.
   *
   * @return List of recipes
   * @throws IOException and issues retrieving the list
   */
  public List<Recipe> retrieveRecipeList() throws IOException {
    try (InputStream inputStream = streamFile("/static/json/recipes.json")) {
      RecipesDTO recipes = objectMapper.readValue(inputStream, RecipesDTO.class);
      return recipes.getRecipes();
    }
  }

  /**
   * Stream helper for retrieving the input stream of the json files in the class path.
   *
   * @param path The path with in the class path eg /static/json/myhson.json
   * @return InputStream of the files
   */
  private InputStream streamFile(String path) {
    return this.getClass().getResourceAsStream(path);
  }

  public void setObjectMapper(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }
}
