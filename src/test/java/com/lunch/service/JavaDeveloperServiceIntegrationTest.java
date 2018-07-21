package com.lunch.service;

import com.lunch.model.Recipe;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaDeveloperServiceIntegrationTest {

  @Autowired private JavaDeveloperService developerService;

  /**
   * Tests the recipes returned is 3 not 5. This includes: - Ham and Cheese toastie - Salad - Hot
   * dog: excludes these as missing ingredients: - Fry-Up missing bakes beans - Omlette as missing
   * milk, salt, pepper, spinach
   *
   * @throws IOException parsing exceptions
   */
  @Test
  public void testAllAvailableRecipes() throws IOException {
    assertNotNull(developerService);
    List<Recipe> recipeList = developerService.findMeRecipesImHungry(LocalDate.parse("2018-03-03"));
    assertNotNull(recipeList);
    assertTrue(
        "recipe list is not 3 but " + recipeList.size(), recipeList.size() == 3); // all available
  }

  @Test
  public void testAllUnavailableRecipes() throws IOException {
    assertNotNull(developerService);
    List<Recipe> recipeList = developerService.findMeRecipesImHungry(LocalDate.parse("2019-03-03"));
    assertNotNull(recipeList);
    assertTrue(recipeList.isEmpty());
  }

}
