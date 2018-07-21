package com.lunch.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class IngredientTest {

    @Test
    public void testDeserializeAndSerializeIngredient() throws IOException {
    String serializedIngredient =
        "{\"title\":\"Ham\",\"best-before\":\"2018-07-16\",\"use-by\":\"2018-07-21\"}";

        ObjectMapper mapper = new ObjectMapper();

        Ingredient ingredient = mapper.readValue(serializedIngredient, Ingredient.class);

        assertNotNull(ingredient);
        assertEquals(ingredient.getTitle(), "Ham");
        assertNotNull(ingredient.getBestBefore());
        assertEquals(LocalDate.parse("2018-07-16"), ingredient.getBestBeforeDate());
        assertNotNull(ingredient.getUseBy());
        assertEquals(LocalDate.parse("2018-07-21"), ingredient.getUseByDate());

        String newSerializedIngredient = mapper.writeValueAsString(ingredient);
        assertNotNull(newSerializedIngredient);
        assertFalse(StringUtils.isEmpty(newSerializedIngredient));
    }

}