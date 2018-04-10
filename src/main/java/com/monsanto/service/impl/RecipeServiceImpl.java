package com.monsanto.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monsanto.dao.RecipeDAO;
import com.monsanto.exception.InvalidIngredientCountException;
import com.monsanto.exception.NoRecordsFoundException;
import com.monsanto.form.RecipeForm;
import com.monsanto.model.Recipe;
import com.monsanto.service.RecipeService;
import com.monsanto.util.Format;

@Service(RecipeServiceImpl.SERVICE_NAME)
public class RecipeServiceImpl extends GenericServiceImpl<Recipe, String> implements RecipeService {

	/**
	 * Declared Service name.
	 */
	public static final String SERVICE_NAME = "recipeService";
	
	@Autowired
	private RecipeDAO recipeDAO;
	
	@Override
	public void addRecipe(RecipeForm recipeForm) throws InvalidIngredientCountException{
		Recipe recipe = null;
		if(Format.isStringNotEmptyAndNotNull(recipeForm.getRecipeId())) {
			recipe = recipeDAO.findOne(recipeForm.getRecipeId());
		}else {
			recipe = new Recipe();
		}
		recipe.setRecipeName(recipeForm.getRecipeName());
		List<String> strings = new ArrayList<>();
		if(Format.isStringNotEmptyAndNotNull(recipeForm.getIngredient1())) {
			strings.add(recipeForm.getIngredient1());
		}
		if(Format.isStringNotEmptyAndNotNull(recipeForm.getIngredient2())) {
			strings.add(recipeForm.getIngredient2());
		}
		if(Format.isStringNotEmptyAndNotNull(recipeForm.getIngredient3())) {
			strings.add(recipeForm.getIngredient3());
		}
		if(Format.isStringNotEmptyAndNotNull(recipeForm.getIngredient4())) {
			strings.add(recipeForm.getIngredient4());
		}
		if(!Format.isCollectionNotEmtyAndNotNull(strings)) {
			throw new InvalidIngredientCountException();
		}
		if(strings.size() < 0 || strings.size() > 4) {
			throw new InvalidIngredientCountException();
		}
		recipe.setIngredients(strings);
		recipeDAO.save(recipe);
	}

	@Override
	public RecipeForm getRecipe(RecipeForm recipeForm) throws NoRecordsFoundException {
		Recipe recipe = recipeDAO.findOne(recipeForm.getRecipeId());
		if(Format.isObjectNotEmptyAndNotZero(recipe)) {
			recipeForm.setRecipeName(recipe.getRecipeName());
			recipeForm.setIngredient1(recipe.getIngredients().get(0));
			recipeForm.setIngredient2(recipe.getIngredients().get(0));
			recipeForm.setIngredient3(recipe.getIngredients().get(2));
			recipeForm.setIngredient4(recipe.getIngredients().get(3));
		}else {
			throw new NoRecordsFoundException();
		}
		return recipeForm;
	}
	
	@Override
	public List<Recipe> getRecipes(RecipeForm recipeForm){
		List<Recipe> recipes = recipeDAO.findAll();
		if(!Format.isCollectionNotEmtyAndNotNull(recipes)) {
			recipes = new ArrayList<>();
		}
		return recipes;
	}
	
	@Override
	public void updateRecipe(RecipeForm recipeForm) throws NoRecordsFoundException, InvalidIngredientCountException{
		Recipe recipe = recipeDAO.findOne(recipeForm.getRecipeId());
		if(Format.isObjectNotEmptyAndNotZero(recipe)) {
			recipe.setRecipeName(recipeForm.getRecipeName());
			List<String> strings = new ArrayList<>();
			if(Format.isStringNotEmptyAndNotNull(recipeForm.getIngredient1())) {
				strings.add(recipeForm.getIngredient1());
			}
			if(Format.isStringNotEmptyAndNotNull(recipeForm.getIngredient2())) {
				strings.add(recipeForm.getIngredient2());
			}
			if(Format.isStringNotEmptyAndNotNull(recipeForm.getIngredient3())) {
				strings.add(recipeForm.getIngredient3());
			}
			if(Format.isStringNotEmptyAndNotNull(recipeForm.getIngredient4())) {
				strings.add(recipeForm.getIngredient4());
			}
			if(!Format.isCollectionNotEmtyAndNotNull(strings)) {
				throw new InvalidIngredientCountException();
			}
			if(strings.size() < 0 || strings.size() > 4) {
				throw new InvalidIngredientCountException();
			}
			recipe.setIngredients(strings);
			recipeDAO.save(recipe);
		}else {
			throw new NoRecordsFoundException();
		}
	}
	
	@Override
	public void deleteRecipe(RecipeForm recipeForm) throws NoRecordsFoundException{
		Recipe recipe = recipeDAO.findOne(recipeForm.getRecipeId());
		if(Format.isObjectNotEmptyAndNotZero(recipe)) {
			recipeDAO.delete(recipe);
		}else {
			throw new NoRecordsFoundException();
		}
	}
	
	@Override
	public void deleteAllRecipe(RecipeForm recipeForm) throws NoRecordsFoundException{
		List<Recipe> recipes = recipeDAO.findAll();
		if(Format.isCollectionNotEmtyAndNotNull(recipes)) {
			for(Recipe recipe:recipes) {
				recipeDAO.delete(recipe);
			}
		}else {
			throw new NoRecordsFoundException();
		}
	}
}
