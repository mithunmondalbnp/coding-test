package com.monsanto.service;

import java.util.List;

import com.monsanto.exception.InvalidIngredientCountException;
import com.monsanto.exception.NoRecordsFoundException;
import com.monsanto.form.RecipeForm;
import com.monsanto.model.Recipe;

public interface RecipeService extends GenericService<Recipe, String>{

	public void addRecipe(RecipeForm recipeForm) throws InvalidIngredientCountException;
	
	public RecipeForm getRecipe(RecipeForm recipeForm) throws NoRecordsFoundException;
	
	public List<Recipe> getRecipes(RecipeForm recipeForm);
	
	public void updateRecipe(RecipeForm recipeForm) throws NoRecordsFoundException, InvalidIngredientCountException;
	
	public void deleteRecipe(RecipeForm recipeForm) throws NoRecordsFoundException;
	
	public void deleteAllRecipe(RecipeForm recipeForm) throws NoRecordsFoundException;
}
