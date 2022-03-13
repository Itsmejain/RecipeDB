package com.example.navigationdrawerdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class SearchIngredient  implements Parcelable {
    public String _id;
    public String ingredient;
    public ArrayList<Recipe> recipes;

    public SearchIngredient(String _id, String ingredient, ArrayList<Recipe> recipes) {
        this._id = _id;
        this.ingredient = ingredient;
        this.recipes = recipes;
    }

    protected SearchIngredient(Parcel in) {
        _id = in.readString();
        ingredient = in.readString();
    }

    public static final Creator<SearchIngredient> CREATOR = new Creator<SearchIngredient>() {
        @Override
        public SearchIngredient createFromParcel(Parcel in) {
            return new SearchIngredient(in);
        }

        @Override
        public SearchIngredient[] newArray(int size) {
            return new SearchIngredient[size];
        }
    };

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_id);
        parcel.writeString(ingredient);
    }
}
class Recipe{
    public String sub_region;
    public String  recipe_id;
    public String recipe_title;
    public String region;

    public Recipe(String sub_region, String recipe_id, String recipe_title, String region) {
        this.sub_region = sub_region;
        this.recipe_id = recipe_id;
        this.recipe_title = recipe_title;
        this.region = region;
    }

    public String getSub_region() {
        return sub_region;
    }

    public void setSub_region(String sub_region) {
        this.sub_region = sub_region;
    }

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getRecipe_title() {
        return recipe_title;
    }

    public void setRecipe_title(String recipe_title) {
        this.recipe_title = recipe_title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}