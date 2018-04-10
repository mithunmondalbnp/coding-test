package com.monsanto.dao.impl;

import org.springframework.stereotype.Repository;

import com.monsanto.dao.RecipeDAO;
import com.monsanto.model.Recipe;

@Repository(RecipeDAOImpl.DAO_NAME)
public class RecipeDAOImpl extends GenericDAOImpl<Recipe, String> implements RecipeDAO {

	/**
	 * Declared DAO_NAME.
	 */
	public static final String DAO_NAME = "recipeDAO";
	
	public RecipeDAOImpl() {
		super(Recipe.class);
	}
}
