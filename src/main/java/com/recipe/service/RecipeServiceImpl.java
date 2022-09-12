package com.recipe.service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.exception.InvalidIngredientException;
import com.recipe.exception.RecipeNotFoundExcpetion;
import com.recipe.model.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Override
	public List<Recipe> getAllRecipes() {
		List<Recipe> recipes = new ArrayList<>();
		
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			recipes = objectMapper.readValue(Paths.get("src/main/resources/receipe.json").toFile(), new TypeReference<List<Recipe>>() { });

		} catch (IOException e) {
			throw new RecipeNotFoundExcpetion("Error while reading recipe json");
		}

		List<Recipe> sortedRecipes = recipes.stream().sorted(Comparator.comparing(Recipe::getTitle)).collect(Collectors.toList());
		return sortedRecipes;
	}


	@Override
	public List<Recipe> getRecipesByIngredients(List<String> ingredients){
		List<String> processedIngrds = ingredients.stream().map(i->i.toLowerCase()).map(i-> i.trim()).collect(Collectors.toList());
		boolean validIngr = processedIngrds.stream().allMatch(s->isAlpha(s));

		if(validIngr) {
			List<Recipe> recipes = getAllRecipes();	

			List<Recipe> filteredRecipes = recipes.stream().filter(p-> p.getIngredients().containsAll(processedIngrds))
					.collect(Collectors.toList());

			return filteredRecipes;
		}
		else {

			throw new InvalidIngredientException("Invalid ingredient found") ;
		}
	}

	public static boolean isAlpha(String s) {
		return (s != null && s.chars().allMatch(Character::isLetter)) || s.chars().anyMatch(Character::isSpaceChar) && !s.chars().anyMatch(Character::isDigit) ;
	}


	@Override
	public Set<String> getAllIngredients() {
		List<Recipe> recipes = getAllRecipes();

		Set<String> ingredients = recipes.stream()
				.flatMap(r->r.getIngredients().stream()).collect(Collectors.toSet());
		
		return ingredients;
	}

}
