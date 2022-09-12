package com.recipe.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.recipe.exception.InvalidIngredientException;
import com.recipe.model.Recipe;

public class RecipeServiceTest {

	@Test
	public void testAllRecipes() throws JsonMappingException, JsonProcessingException {
		RecipeService service = new RecipeServiceImpl();

		List<Recipe> recipes = service.getAllRecipes();
		assertFalse(recipes.isEmpty());
	}

	@Test
	public void testGetAllIngredients() {
		RecipeService service = new RecipeServiceImpl();
		Set<String> ingrs = service.getAllIngredients();
		System.out.println("ingrs {}" +ingrs);
		assertFalse(ingrs.isEmpty());

	}


	@Test
	public void testGetRescipesByIngedients() {
		RecipeService service = new RecipeServiceImpl();
		List<String> ingrds = new ArrayList<String>();
		ingrds.add("onions");

		List<Recipe> recipes = service.getRecipesByIngredients(ingrds);
		assertFalse(recipes.isEmpty());
		assertTrue(recipes.stream().anyMatch(p->p.getTitle().equalsIgnoreCase("Creamy Scrambled Eggs Recipe Recipe")));

	}


	@Test
	public void testExceptionInputIngredients() {

		RecipeService service = new RecipeServiceImpl();
		List<String> ingrds = new ArrayList<String>();
		ingrds.add("onions8");

		assertThrowsExactly(InvalidIngredientException.class, ()-> service.getRecipesByIngredients(ingrds));		


	}






}
