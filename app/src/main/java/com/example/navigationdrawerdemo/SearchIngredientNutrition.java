package com.example.navigationdrawerdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchIngredientNutrition implements Parcelable {
    public String _id;
    public String ingredient;
    public String ing_id;
    public String fat;
    public String frequency;
    public String energy;
    public String protein;
    public String carbohydrate;

    public SearchIngredientNutrition(String _id, String ingredient, String ing_id, String fat, String frequency, String energy, String protein, String carbohydrate) {
        this._id = _id;
        this.ingredient = ingredient;
        this.ing_id = ing_id;
        this.fat = fat;
        this.frequency = frequency;
        this.energy = energy;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
    }

    protected SearchIngredientNutrition(Parcel in) {
        _id = in.readString();
        ingredient = in.readString();
        ing_id = in.readString();
        fat = in.readString();
        frequency = in.readString();
        energy = in.readString();
        protein = in.readString();
        carbohydrate = in.readString();
    }

    public static final Creator<SearchIngredientNutrition> CREATOR = new Creator<SearchIngredientNutrition>() {
        @Override
        public SearchIngredientNutrition createFromParcel(Parcel in) {
            return new SearchIngredientNutrition(in);
        }

        @Override
        public SearchIngredientNutrition[] newArray(int size) {
            return new SearchIngredientNutrition[size];
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

    public String getIng_id() {
        return ing_id;
    }

    public void setIng_id(String ing_id) {
        this.ing_id = ing_id;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_id);
        parcel.writeString(ingredient);
        parcel.writeString(ing_id);
        parcel.writeString(fat);
        parcel.writeString(frequency);
        parcel.writeString(energy);
        parcel.writeString(protein);
        parcel.writeString(carbohydrate);
    }
}
