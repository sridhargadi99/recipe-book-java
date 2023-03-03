/*
 * 
 * You can use the following import statements
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.recipe;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.recipe.Recipe;
import com.example.recipe.RecipeService;

@RestController
public class RecipeController{
    RecipeService service = new RecipeService();

    @GetMapping("/recipes")
    public ArrayList<Recipe> getAllRecipes(){
        return service.getAllRecipes();
    }

    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return service.addRecipe(recipe);
    }

    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipe(@PathVariable ("recipeId") int recipeId){
        return service.getRecipe(recipeId);
    }

    @PutMapping("/recipes/{recipeId}")
    public Recipe updateRecipe(@PathVariable ("recipeId") int recipeId, @RequestBody Recipe recipe){
        return service.updateRecipe(recipeId, recipe);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public void deleteRecipe(@PathVariable ("recipeId") int recipeId){
        service.deleteRecipe(recipeId);
    }
    
}
