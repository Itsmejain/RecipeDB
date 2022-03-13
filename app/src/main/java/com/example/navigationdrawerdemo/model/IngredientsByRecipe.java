package com.example.navigationdrawerdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class IngredientsByRecipe implements Parcelable {

    public String _id;
    public String recipe_no;
    public String ingredient_Phrase;
    public String ingredient;
    public String state;
    public String quantity;
    public String unit;
    public String temp;
    public String df;
    public String size;
    public String ing_id;
    public String ndb_id;
    public String m_or_A;

    public IngredientsByRecipe(String _id, String recipe_no, String ingredient_Phrase, String ingredient, String state, String quantity, String unit, String temp, String df, String size, String ing_id, String ndb_id, String m_or_A) {
        this._id = _id;
        this.recipe_no = recipe_no;
        this.ingredient_Phrase = ingredient_Phrase;
        this.ingredient = ingredient;
        this.state = state;
        this.quantity = quantity;
        this.unit = unit;
        this.temp = temp;
        this.df = df;
        this.size = size;
        this.ing_id = ing_id;
        this.ndb_id = ndb_id;
        this.m_or_A = m_or_A;
    }

    protected IngredientsByRecipe(Parcel in) {
        _id = in.readString();
        recipe_no = in.readString();
        ingredient_Phrase = in.readString();
        ingredient = in.readString();
        state = in.readString();
        quantity = in.readString();
        unit = in.readString();
        temp = in.readString();
        df = in.readString();
        size = in.readString();
        ing_id = in.readString();
        ndb_id = in.readString();
        m_or_A = in.readString();
    }

    public static final Creator<IngredientsByRecipe> CREATOR = new Creator<IngredientsByRecipe>() {
        @Override
        public IngredientsByRecipe createFromParcel(Parcel in) {
            return new IngredientsByRecipe(in);
        }

        @Override
        public IngredientsByRecipe[] newArray(int size) {
            return new IngredientsByRecipe[size];
        }
    };

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRecipe_no() {
        return recipe_no;
    }

    public void setRecipe_no(String recipe_no) {
        this.recipe_no = recipe_no;
    }

    public String getIngredient_Phrase() {
        return ingredient_Phrase;
    }

    public void setIngredient_Phrase(String ingredient_Phrase) {
        this.ingredient_Phrase = ingredient_Phrase;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDf() {
        return df;
    }

    public void setDf(String df) {
        this.df = df;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIng_id() {
        return ing_id;
    }

    public void setIng_id(String ing_id) {
        this.ing_id = ing_id;
    }

    public String getNdb_id() {
        return ndb_id;
    }

    public void setNdb_id(String ndb_id) {
        this.ndb_id = ndb_id;
    }

    public String getM_or_A() {
        return m_or_A;
    }

    public void setM_or_A(String m_or_A) {
        this.m_or_A = m_or_A;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_id);
        parcel.writeString(recipe_no);
        parcel.writeString(ingredient_Phrase);
        parcel.writeString(ingredient);
        parcel.writeString(state);
        parcel.writeString(quantity);
        parcel.writeString(unit);
        parcel.writeString(temp);
        parcel.writeString(df);
        parcel.writeString(size);
        parcel.writeString(ing_id);
        parcel.writeString(ndb_id);
        parcel.writeString(m_or_A);
    }
}
