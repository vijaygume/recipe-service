package com.recipe.service;

import java.util.List;
import java.util.Set;

import com.recipe.model.Recipe;

public interface RecipeService {
	
	public List<Recipe> getAllRecipes();
	
	public List<Recipe> getRecipesByIngredients(List<String> ingredients);
	
	public Set<String> getAllIngredients();

}
