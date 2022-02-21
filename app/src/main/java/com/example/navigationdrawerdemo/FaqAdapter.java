package com.example.navigationdrawerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {
    Context context;
    ArrayList<FAQ> qaList;

    public FaqAdapter(Context context,ArrayList<FAQ> qaList){
        this.context = context;
        this.qaList=qaList;
    }

    @NonNull
    @Override
    public FaqAdapter.FaqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.faq_item,parent,false);
        return new FaqViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqAdapter.FaqViewHolder holder, int position) {
        FAQ faq = qaList.get(position);
        holder.tvHeading.setText(faq.question);
        holder.answer.setText(faq.answer);

        boolean isVisible = faq.visibility;
        holder.constraintLayout.setVisibility(isVisible? View.VISIBLE: View.GONE);
    }

    @Override
    public int getItemCount() {
        return qaList.size();
    }

    public class FaqViewHolder extends RecyclerView.ViewHolder{
        TextView tvHeading;
        TextView answer;
        ConstraintLayout constraintLayout;
        public FaqViewHolder(@NonNull View itemView){
            super(itemView);
            tvHeading = itemView.findViewById(R.id.tvHeading);
            answer = itemView.findViewById(R.id.answer);
            constraintLayout = itemView.findViewById(R.id.expndedLayout);
            tvHeading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FAQ faq = qaList.get(getAdapterPosition());
                    faq.setVisibility(!faq.isVisibility());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
