package com.example.navigationdrawerdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FaqFragment extends Fragment {
    String [] question;
    String [] answer;
    FaqAdapter faqAdapter;
    ArrayList<FAQ> qaArray;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        qList=new ArrayList<String>();
        View v = inflater.inflate(R.layout.fragment_faq,container,false);

        question = new String[]{"dummy",
                "What is RecipeDB?",
                "What types of queries are processed by RecipeDB?",
                "How do I use “Recipe Search”?",
                "How do I use “Advanced Search”?",
                "What are the various recipes within RecipeDB?",
                "What are RecipeDB Statistics?",
                "What are the prerequisites required in order to use RecipeDB?",
                "How does the ‘Find Similar Recipes’ feature work?",
                "How does RecipeDB estimate a recipe’s nutritional profile?",
                "What are the categories ingredients are sorted into?",
                "How does the integration of RecipeDB with DietRx and FlavorDB work?",
                "What browsers are supported by RecipeDB?",
                "What is the Tech Stack used to build RecipeDB?",
                "What are the sources of information for RecipeDB?"
        };

        answer = new String[]{"answerDummy",
                "RecipeDB is a structured repository of recipes and ingredients from over 22 world regions, intended to enable data-driven explorations of recipes. In conjunction with flavor molecules data from FlavorDB; RecipeDB facilitates multi-level analysis of traditional recipes (dietary classifications, ingredient composition, nutritional profile, recipes, etc.).",
                "RecipeDB facilitates an elastic search to query recipes based on factors such as geographical location of origin (i.e. region, country), name, dietary classification, ingredients associated/unassociated with the recipe and its nutritional information (i.e. calorie, protein, etc. content).",
                "Refer to the “Search” section on the “How to Use” page.",
                "Refer to the “Advanced Search” section on the “How to Use” page.",
                "A list of all the recipes in RecipeDB can be obtained by simply hitting the ‘Search’ button on the recipe search page without providing any specific query.",
                "RecipeDB Statistics explain the vastness and depth of RecipeDB using interactive plots made using Plotly.",
                "A modern web browser.",
                "The similarity in recipes was ascertained based on shared category composition of ingredients and processes.",
                "For every ingredient of a recipe its features were extracted: ingredient name, state, quantity, unit, dry/fresh, temperature, and size. Using the name of the ingredient and its state, each ingredient was mapped to a unique ‘NDB ID’ from USDA database. Further using the standard nutrition data from USDA data tables, the nutritional profile of the ingredient was estimated by mapping quantity and unit. The final ‘estimated nutritional profile’ is a sum total of nutritional values of each ingredient in it.",
                "The ingredients were manually curated into the 23 categories given below:\n" +
                        "• Additive\n" +
                        "• Bakery\n" +
                        "• Beverage\n" +
                        "• Beverage-Alcoholic\n" +
                        "• Cereal\n" +
                        "• Condiment\n" +
                        "• Dairy\n" +
                        "• Dish\n" +
                        "• Essential Oil\n" +
                        "• Fish\n" +
                        "• Fruit\n" +
                        "• Fungi\n" +
                        "• Herb\n" +
                        "• Legume\n" +
                        "• Maize\n" +
                        "• Meat\n" +
                        "• Nuts and Seeds\n" +
                        "• Plant\n" +
                        "• Plant Derivative\n" +
                        "• Seafood\n" +
                        "• Spice\n" +
                        "• Vegetable",
                "For each ingredient found in recipes of the database, a ‘Generic Ingredient Name’ was assigned manually to account for degeneracy due to derivative products. For each generic ingredient the FlavorDB ID and DietRx ID were manually labelled. These external resources provide details of the ‘Flavor Profile’ and ‘Health Impacts’ of the ingredient, respectively.",
                "RecipeDB supports all modern web browsers, but it can be best viewed on Chrome, Firefox and Edge.",
                "Frontend: Bootstrap, Materialize CSS, JavaScript, Google Charts, Plotly\n" +
                        "\n" +
                        "Backend: Flask, SQLite, Python",
                "RecipeDB has sourced the recipes from many online resources, and its nutritional information from the USDA Food Composition Databases."
        };
        qaArray = new ArrayList<FAQ>();


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        getData();
    }

    private void getData(){
        for(int i=0;i<question.length;i++){
            FAQ qa = new FAQ(question[i],answer[i]);
            qaArray.add(qa);
        }

        faqAdapter = new FaqAdapter(getActivity(),qaArray);
        recyclerView.setAdapter(faqAdapter);
        faqAdapter.notifyDataSetChanged();
    }


}
