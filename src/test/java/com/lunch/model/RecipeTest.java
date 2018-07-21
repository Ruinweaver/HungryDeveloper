package com.lunch.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lunch.test.TestUtil;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

public class RecipeTest {

  @Test
  public void testDeserializeAndSerializeRecipe() throws IOException {
    String serializedRecipe =
        "{\"title\":\"Ham and Cheese Toastie\",\"ingredients\":[\"Ham\",\"Cheese\",\"Bread\",\"Butter\"]}";

    ObjectMapper mapper = new ObjectMapper();

    Recipe recipe = mapper.readValue(serializedRecipe, Recipe.class);

    assertNotNull(recipe);
    assertEquals(recipe.getTitle(), "Ham and Cheese Toastie");
    assertNotNull(recipe.getIngredients());
    assertTrue(recipe.getIngredients().size() == 4);

    recipe.getIngredients().containsAll(TestUtil.asList("Butter", "Bread", "Cheese", "Ham"));

    String newSerializedRecipe = mapper.writeValueAsString(recipe);
    assertNotNull(newSerializedRecipe);
    assertTrue(newSerializedRecipe.startsWith("{\"title\":\"Ham and Cheese Toastie\",\"ingredients\":["));
  }

}
