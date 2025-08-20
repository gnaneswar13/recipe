package com.example.recipe;

import java.util.*;

public class RecipeService implements RecipeRepository {

    private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();
    private static int currentId = 5; // since 5 recipes are preloaded

    public RecipeService() {
        recipeBook.put(1,
                new Recipe(1, "Pasta", "veg",
                        Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
        recipeBook.put(2,
                new Recipe(2, "Chicken Curry", "non-veg",
                        Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
        recipeBook.put(3,
                new Recipe(3, "Sushi", "non-veg",
                        Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
        recipeBook.put(4,
                new Recipe(4, "Mushroom Risotto", "veg",
                        Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
        recipeBook.put(5,
                new Recipe(5, "Fish and Chips", "non-veg",
                        Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
    }

    // ✅ API 1: Get all recipes
    @Override
    public ArrayList<Recipe> getRecipes() {
        return new ArrayList<>(recipeBook.values());
    }

    // ✅ API 3: Get recipe by ID
    @Override
    public Recipe getRecipeById(int recipeId) {
        return recipeBook.get(recipeId);
    }

    // ✅ API 2: Add a new recipe (auto-increment ID)
    @Override
    public Recipe addRecipe(Recipe recipe) {
        int newId = ++currentId;
        recipe.setRecipeId(newId);
        recipeBook.put(newId, recipe);
        return recipe;
    }

    // ✅ API 4: Update recipe by ID
    @Override
    public Recipe updateRecipe(int recipeId, Recipe updatedRecipe) {
        if (!recipeBook.containsKey(recipeId)) {
            return null;
        }
        updatedRecipe.setRecipeId(recipeId);
        recipeBook.put(recipeId, updatedRecipe);
        return updatedRecipe;
    }

    // ✅ API 5: Delete recipe by ID
    @Override
    public void deleteRecipe(int recipeId) {
        recipeBook.remove(recipeId);
    }
}
