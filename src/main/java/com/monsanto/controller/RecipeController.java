package com.monsanto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monsanto.constants.Constant;
import com.monsanto.exception.InvalidIngredientCountException;
import com.monsanto.exception.NoRecordsFoundException;
import com.monsanto.form.RecipeForm;
import com.monsanto.model.Recipe;
import com.monsanto.service.RecipeService;
import com.monsanto.util.Format;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	/**
	 * @param model
	 * @return the index/home page for the Monsanto Front end Web Application
	 */
	@RequestMapping(value = { "/", "/home", "/index" })
	public String indexPage(Model model) {
		List<RecipeForm> recipeForms = new ArrayList<>();
		List<Recipe> recipes = recipeService.getRecipes(null);
		if(Format.isCollectionNotEmtyAndNotNull(recipes)) {
			for(Recipe recipe:recipes) {
				RecipeForm recipeForm = new RecipeForm();
				recipeForm.setRecipeName(recipe.getRecipeName());
				recipeForm.setRecipeId(recipe.getRecipeId().toString());
				recipeForms.add(recipeForm);
			}
		}
		model.addAttribute("recipes", recipeForms);
		return "index";
	}
	
	//-------------------Create a Recipe--------------------------------------------------------
	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
    public @ResponseBody RecipeForm addRecipe(@RequestBody RecipeForm recipeForm) {
        if (Format.isStringNotEmptyAndNotNull(recipeForm.getRecipeName())) {
        	try {
        		recipeService.addRecipe(recipeForm);
            	recipeForm.setSuccessOrErrorMessage(Constant.RECIPE_ADDED_SUCCESSFULLY);
            	recipeForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        	}catch (InvalidIngredientCountException e) {
        		recipeForm.setSuccessOrErrorMessage(Constant.INVALID_INGREDIENT_COUNT);
        		recipeForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
			}
        }else {
        	recipeForm.setSuccessOrErrorMessage(Constant.RECIPE_NAME);
    		recipeForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
        }
        return recipeForm;
    }
	
	//-------------------Retrieve Single Recipe--------------------------------------------------------
    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
    public @ResponseBody RecipeForm getRecipe(@PathVariable("id") String id) {
    	RecipeForm recipeForm = new RecipeForm();
        if(Format.isStringNotEmptyAndNotNull(id)) {
        	recipeForm.setRecipeId(id);
        	try {
        		recipeService.getRecipe(recipeForm);
        		recipeForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        	}catch (NoRecordsFoundException e) {
        		recipeForm.setSuccessOrErrorMessage(Constant.NO_RECORD_FOUND);
        		recipeForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
			}
        }
        return recipeForm;
    }
    
   //-------------------Retrieve All Recipe--------------------------------------------------------
    @RequestMapping(value = "/recipe", method = RequestMethod.GET)
    public @ResponseBody RecipeForm listAllRecipes() {
       RecipeForm recipeForm = new RecipeForm();
       List<Recipe> recipes = recipeService.getRecipes(recipeForm);
	   recipeForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
	   recipeForm.setRecipes(recipes);
       return recipeForm;
    }
    
    //------------------- Update a Recipe --------------------------------------------------------
    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.PUT)
    public @ResponseBody RecipeForm updateRecipe(@PathVariable("id") String id, @RequestBody RecipeForm recipeForm) {
        recipeForm.setRecipeId(id);
        try {
     	   recipeService.updateRecipe(recipeForm);
     	   recipeForm.setSuccessOrErrorMessage(Constant.RECIPE_UPDATED_SUCCESSFULLY);
     	   recipeForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        }catch (NoRecordsFoundException e) {
     	   recipeForm.setSuccessOrErrorMessage(Constant.NO_RECORD_FOUND);
     	   recipeForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
        }catch (InvalidIngredientCountException e) {
      	   recipeForm.setSuccessOrErrorMessage(Constant.INVALID_INGREDIENT_COUNT);
      	   recipeForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
         }
        return recipeForm;
    }
 
    //------------------- Delete a Recipe --------------------------------------------------------
    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.DELETE)
    public @ResponseBody RecipeForm deleteRecipe(@PathVariable("id") String id) {
    	RecipeForm recipeForm = new RecipeForm();
    	recipeForm.setRecipeId(id);
        try {
     	   recipeService.deleteRecipe(recipeForm);
     	   recipeForm.setSuccessOrErrorMessage(Constant.RECIPE_DELETED_SUCCESSFULLY);
     	   recipeForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        }catch (NoRecordsFoundException e) {
     	   recipeForm.setSuccessOrErrorMessage(Constant.NO_RECORD_FOUND);
     	   recipeForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
        }
        return recipeForm;
    }
    
    //------------------- Delete All Recipes --------------------------------------------------------
    @RequestMapping(value = "/recipe", method = RequestMethod.DELETE)
    public @ResponseBody RecipeForm deleteAllRecipes() {
    	RecipeForm recipeForm = new RecipeForm();
        try {
     	   recipeService.deleteAllRecipe(recipeForm);
     	   recipeForm.setSuccessOrErrorMessage(Constant.RECIPE_DELETED_ALL_SUCCESSFULLY);
     	   recipeForm.setMessageType(Constant.MESSAGE_TYPE_SUCCESS);
        }catch (NoRecordsFoundException e) {
     	   recipeForm.setSuccessOrErrorMessage(Constant.NO_RECORD_FOUND);
     	   recipeForm.setMessageType(Constant.MESSAGE_TYPE_FAILURE);
        }
        return recipeForm;
    }
}
