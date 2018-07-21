package com.lunch.controller;

import com.lunch.model.Recipe;
import com.lunch.service.JavaDeveloperService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/** A controller for a Hungry Java Developer. */
@RestController
public class JavaDeveloperController {

  @Autowired private JavaDeveloperService javaDeveloperService;

  /**
   * Lets get lunch ... 12:00 o'clock... Java can wait... for now
   *
   * @return A list of Recipes.
   */
  @RequestMapping(
      value = "/lunch",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<Recipe> lunchWithUnexpiredIngredients(
      @RequestParam(required = false) String date) throws IOException {
    LocalDate dateToCheck = javaDeveloperService.parseDate(date);
    return javaDeveloperService.findMeRecipesImHungry(dateToCheck);
  }
}
