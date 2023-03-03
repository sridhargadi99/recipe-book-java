package com.example.recipe;

import com.example.recipe.RecipeRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.recipe.Recipe;

import java.util.*;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();
        int uniqueRecipeId = 6;

        public RecipeService() {
                recipeBook.put(1,
                                new Recipe(1, "Pasta", "veg",
                                                Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        // Don't modify the above code

        // Write your code here
        @Override 
        public ArrayList<Recipe> getAllRecipes(){
                Collection<Recipe> recipeCollection = recipeBook.values();
                ArrayList<Recipe> allRecipes = new ArrayList<>(recipeCollection);
                return allRecipes;
        }

        @Override
        public Recipe addRecipe(Recipe recipe){
                recipe.setRecipeId(uniqueRecipeId);
                recipeBook.put(uniqueRecipeId, recipe);
                uniqueRecipeId += 1;
                return recipe;
        }

        @Override 
        public Recipe getRecipe(int recipeId){
                Recipe recipeDetails = recipeBook.get(recipeId);
                if(recipeDetails == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                return recipeDetails;
        }

        @Override 
        public Recipe updateRecipe(int recipeId, Recipe recipe){
                Recipe recipeDetails = recipeBook.get(recipeId);
                if(recipeDetails == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }

                if(recipe.getRecipeName() != null){
                        recipeDetails.setRecipeName(recipe.getRecipeName());
                }

                if(recipe.getRecipeType() != null){
                        recipeDetails.setRecipeType(recipe.getRecipeType());
                }

                if(recipe.getIngredients() != null){
                        recipeDetails.setIngredients(recipe.getIngredients());
                }

                return recipeDetails;
        }

        @Override
        public void deleteRecipe(int recipeId){
                Recipe recipeDetails = recipeBook.get(recipeId);
                if(recipeDetails == null){
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                else{
                        recipeBook.remove(recipeId);
                        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }
        }
}