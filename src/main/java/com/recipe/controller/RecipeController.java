package com.recipe.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.model.Recipe;
import com.recipe.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/recipe")
@Slf4j
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;

	@GetMapping("/recipes")
	public List<Recipe> getAllRecipes() {
		
		return recipeService.getAllRecipes();
	}
	
	@PostMapping("/recipesByIngredients")
	public List<Recipe> getRecipesByIngredients(@RequestBody List<String> ingredients){
		
		
		log.info("ingredients : {}", ingredients);
		
		return recipeService.getRecipesByIngredients(ingredients);
	}
	
	@GetMapping("/ingredients")
	public Set<String> getAllIngredients() {
		
		return recipeService.getAllIngredients();
	}
	
	
}
