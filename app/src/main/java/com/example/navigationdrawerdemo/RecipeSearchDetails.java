package com.example.navigationdrawerdemo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

//THIS CLASS HOLDS THE OBJECTS OF THE JSON RESPONSE COMING AS PART OF SEARCH RESULTS
public class RecipeSearchDetails implements Parcelable {
    public String _id;
    public String cook_time;
    public String prep_time;
    public String url;
    public String servings;
    public String img_url;
    public String fat;
    public String total_time;
    public String vegan;
    public String pescetarian;
    public String ovo_vegetarian;
    public String lacto_vegetarian;
    public String ovo_lacto_vegetarian;
    public ArrayList<String> ingredients;
    public ArrayList<String> category;
    public String utensils;
    public String processes;
    public String calories;
    public String continent;
    public String sub_region;
    public String protein;
    public String recipe_id;
    public String recipe_title;
    public String carbohydratebydifference;
    public String energykcal;
    public String region;
    public String source;

    public RecipeSearchDetails(String _id, String cook_time, String prep_time, String url, String servings, String img_url, String fat, String total_time, String vegan, String pescetarian, String ovo_vegetarian, String lacto_vegetarian, String ovo_lacto_vegetarian, ArrayList<String> ingredients, ArrayList<String> category, String utensils, String processes, String calories, String continent, String sub_region, String protein, String recipe_id, String recipe_title, String carbohydratebydifference, String energykcal, String region, String source) {
        this._id = _id;
        this.cook_time = cook_time;
        this.prep_time = prep_time;
        this.url = url;
        this.servings = servings;
        this.img_url = img_url;
        this.fat = fat;
        this.total_time = total_time;
        this.vegan = vegan;
        this.pescetarian = pescetarian;
        this.ovo_vegetarian = ovo_vegetarian;
        this.lacto_vegetarian = lacto_vegetarian;
        this.ovo_lacto_vegetarian = ovo_lacto_vegetarian;
        this.ingredients = ingredients;
        this.category = category;
        this.utensils = utensils;
        this.processes = processes;
        this.calories = calories;
        this.continent = continent;
        this.sub_region = sub_region;
        this.protein = protein;
        this.recipe_id = recipe_id;
        this.recipe_title = recipe_title;
        this.carbohydratebydifference = carbohydratebydifference;
        this.energykcal = energykcal;
        this.region = region;
        this.source = source;
    }

    protected RecipeSearchDetails(Parcel in) {
        _id = in.readString();
        cook_time = in.readString();
        prep_time = in.readString();
        url = in.readString();
        servings = in.readString();
        img_url = in.readString();
        fat = in.readString();
        total_time = in.readString();
        vegan = in.readString();
        pescetarian = in.readString();
        ovo_vegetarian = in.readString();
        lacto_vegetarian = in.readString();
        ovo_lacto_vegetarian = in.readString();
        ingredients = in.createStringArrayList();
        category = in.createStringArrayList();
        utensils = in.readString();
        processes = in.readString();
        calories = in.readString();
        continent = in.readString();
        sub_region = in.readString();
        protein = in.readString();
        recipe_id = in.readString();
        recipe_title = in.readString();
        carbohydratebydifference = in.readString();
        energykcal = in.readString();
        region = in.readString();
        source = in.readString();
    }

    public static final Creator<RecipeSearchDetails> CREATOR = new Creator<RecipeSearchDetails>() {
        @Override
        public RecipeSearchDetails createFromParcel(Parcel in) {
            return new RecipeSearchDetails(in);
        }

        @Override
        public RecipeSearchDetails[] newArray(int size) {
            return new RecipeSearchDetails[size];
        }
    };

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCook_time() {
        return cook_time;
    }

    public void setCook_time(String cook_time) {
        this.cook_time = cook_time;
    }

    public String getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(String prep_time) {
        this.prep_time = prep_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public String getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public String getPescetarian() {
        return pescetarian;
    }

    public void setPescetarian(String pescetarian) {
        this.pescetarian = pescetarian;
    }

    public String getOvo_vegetarian() {
        return ovo_vegetarian;
    }

    public void setOvo_vegetarian(String ovo_vegetarian) {
        this.ovo_vegetarian = ovo_vegetarian;
    }

    public String getLacto_vegetarian() {
        return lacto_vegetarian;
    }

    public void setLacto_vegetarian(String lacto_vegetarian) {
        this.lacto_vegetarian = lacto_vegetarian;
    }

    public String getOvo_lacto_vegetarian() {
        return ovo_lacto_vegetarian;
    }

    public void setOvo_lacto_vegetarian(String ovo_lacto_vegetarian) {
        this.ovo_lacto_vegetarian = ovo_lacto_vegetarian;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public String getUtensils() {
        return utensils;
    }

    public void setUtensils(String utensils) {
        this.utensils = utensils;
    }

    public String getProcesses() {
        return processes;
    }

    public void setProcesses(String processes) {
        this.processes = processes;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getSub_region() {
        return sub_region;
    }

    public void setSub_region(String sub_region) {
        this.sub_region = sub_region;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
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

    public String getCarbohydratebydifference() {
        return carbohydratebydifference;
    }

    public void setCarbohydratebydifference(String carbohydratebydifference) {
        this.carbohydratebydifference = carbohydratebydifference;
    }

    public String getEnergykcal() {
        return energykcal;
    }

    public void setEnergykcal(String energykcal) {
        this.energykcal = energykcal;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_id);
        parcel.writeString(cook_time);
        parcel.writeString(prep_time);
        parcel.writeString(url);
        parcel.writeString(servings);
        parcel.writeString(img_url);
        parcel.writeString(fat);
        parcel.writeString(total_time);
        parcel.writeString(vegan);
        parcel.writeString(pescetarian);
        parcel.writeString(ovo_vegetarian);
        parcel.writeString(lacto_vegetarian);
        parcel.writeString(ovo_lacto_vegetarian);
        parcel.writeStringList(ingredients);
        parcel.writeStringList(category);
        parcel.writeString(utensils);
        parcel.writeString(processes);
        parcel.writeString(calories);
        parcel.writeString(continent);
        parcel.writeString(sub_region);
        parcel.writeString(protein);
        parcel.writeString(recipe_id);
        parcel.writeString(recipe_title);
        parcel.writeString(carbohydratebydifference);
        parcel.writeString(energykcal);
        parcel.writeString(region);
        parcel.writeString(source);
    }
}
