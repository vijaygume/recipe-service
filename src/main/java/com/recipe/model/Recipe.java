package com.recipe.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
	
	private String title;
	private String href;
	private List<String> ingredients;
	private String thumbnail;

}
