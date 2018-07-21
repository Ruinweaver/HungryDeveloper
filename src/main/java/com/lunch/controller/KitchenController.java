package com.lunch.controller;

import com.lunch.model.Ingredient;
import com.lunch.model.Recipe;
import com.lunch.service.KitchenService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/** A controller to return the ingredients that are found in the Java Developers Kitchen. */
@RestController
@RequestMapping("/data")
public class KitchenController {

  @Autowired private KitchenService kitchenService;

  /**
   * A list of ingredients in My Kitchen.
   *
   * @return A list of Ingredients.
   */
  @RequestMapping(
      value = "/ingredients",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<Ingredient> ingredients() throws IOException {
    return kitchenService.allIngredients();
  }

  /**
   * A list of ingredients in My Kitchen.
   *
   * @return A list of Ingredients.
   */
  @RequestMapping(
      value = "/ingredients/{dateToCheck}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Map<String, Ingredient> availableIngredients(
      @PathVariable("dateToCheck") String dateToCheck) throws IOException {
    return kitchenService.availableIngredients(LocalDate.parse(dateToCheck));
  }

  /**
   * Retrieves the recepes in my recipe book.
   *
   * @return A list of recipes.
   */
  @RequestMapping(
      value = "/recipes",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<Recipe> recipes() throws IOException {
    return kitchenService.retrieveRecipeList();
  }
}
