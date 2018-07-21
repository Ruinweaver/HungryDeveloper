package com.lunch.model;

import java.util.List;

/** Simple Data Transferish Object for retrieving the data from the json ingredients data. */
public class IngredientsDTO {
  List<Ingredient> ingredients;

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }
}
