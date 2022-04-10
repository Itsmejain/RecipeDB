package com.example.navigationdrawerdemo.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.fragments.RecipeBottomSheet;
import com.example.navigationdrawerdemo.model.RecipeDetails;
import com.example.navigationdrawerdemo.util.Constants;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder>{
    List<RecipeDetails> recipes;
    private String recipeTitle;

    public SearchResultAdapter(List<RecipeDetails> recipes) {
        this.recipes = recipes;
        Log.d(Constants.TAG, "searchResultAdapter: ");
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String recipeName = (recipes.get(position)).recipe_title;
        holder.recipeTitle.setText(recipeName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecipeBottomSheet recipeBottomSheet = new RecipeBottomSheet();
//                recipeBottomSheet.
//                FragmentManager g = getA
                Toast.makeText(view.getContext(), "row "+position+" clicked", Toast.LENGTH_SHORT).show();
                recipeBottomSheet.show(recipeBottomSheet.getParentFragmentManager(), "BottomSheet");
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView recipeTitle;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            recipeTitle=itemView.findViewById(R.id.tvHeading);
        }
    }
    
    
}
