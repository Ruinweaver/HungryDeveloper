package com.lunch.model;

import java.util.List;

/** Simple Data Transferish Object for retrieving the data from the json recipe data. */
public class RecipesDTO {
  List<Recipe> recipes;

  public List<Recipe> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<Recipe> recipes) {
    this.recipes = recipes;
  }
}
