package com.monsanto.form;

import java.util.List;

import com.monsanto.model.Recipe;

public class RecipeForm {

	private String recipeId;
	
	private String recipeName;
	
	private String ingredient1;
	
	private String ingredient2;
	
	private String ingredient3;
	
	private String ingredient4;
	
	private String successOrErrorMessage;
	
	private String messageType;
	
	private List<Recipe> recipes;

	/**
	 * @return the recipeId
	 */
	public String getRecipeId() {
		return recipeId;
	}

	/**
	 * @param recipeId the recipeId to set
	 */
	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

	/**
	 * @return the recipeName
	 */
	public String getRecipeName() {
		return recipeName;
	}

	/**
	 * @param recipeName the recipeName to set
	 */
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	/**
	 * @return the ingredient1
	 */
	public String getIngredient1() {
		return ingredient1;
	}

	/**
	 * @param ingredient1 the ingredient1 to set
	 */
	public void setIngredient1(String ingredient1) {
		this.ingredient1 = ingredient1;
	}

	/**
	 * @return the ingredient2
	 */
	public String getIngredient2() {
		return ingredient2;
	}

	/**
	 * @param ingredient2 the ingredient2 to set
	 */
	public void setIngredient2(String ingredient2) {
		this.ingredient2 = ingredient2;
	}

	/**
	 * @return the ingredient3
	 */
	public String getIngredient3() {
		return ingredient3;
	}

	/**
	 * @param ingredient3 the ingredient3 to set
	 */
	public void setIngredient3(String ingredient3) {
		this.ingredient3 = ingredient3;
	}

	/**
	 * @return the ingredient4
	 */
	public String getIngredient4() {
		return ingredient4;
	}

	/**
	 * @param ingredient4 the ingredient4 to set
	 */
	public void setIngredient4(String ingredient4) {
		this.ingredient4 = ingredient4;
	}

	/**
	 * @return the successOrErrorMessage
	 */
	public String getSuccessOrErrorMessage() {
		return successOrErrorMessage;
	}

	/**
	 * @param successOrErrorMessage the successOrErrorMessage to set
	 */
	public void setSuccessOrErrorMessage(String successOrErrorMessage) {
		this.successOrErrorMessage = successOrErrorMessage;
	}

	/**
	 * @return the messageType
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return the recipes
	 */
	public List<Recipe> getRecipes() {
		return recipes;
	}

	/**
	 * @param recipes the recipes to set
	 */
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
}
