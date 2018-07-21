package com.lunch.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Set;

/** Immutable class consisting of a Single Recipe Data. */
public class Recipe {
  private String title;
  private Set<String> ingredients;

  /**
   * Immutable Recipe object.
   *
   * @param title The title of the recipe
   * @param ingredients The ingredients for the recipe
   */
  @JsonCreator
  public Recipe(
      @JsonProperty("title") String title, @JsonProperty("ingredients") Set<String> ingredients) {
    this.title = title;
    this.ingredients = ingredients;
  }

  public String getTitle() {
    return title;
  }

  public Set<String> getIngredients() {
    return ingredients;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(title, recipe.title) && Objects.equals(ingredients, recipe.ingredients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, ingredients);
  }

  @Override
  public String toString() {
    return "Recipe{" + "title='" + title + '\'' + ", ingredients=" + ingredients + '}';
  }
}
