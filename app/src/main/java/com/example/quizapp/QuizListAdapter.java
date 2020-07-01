package com.example.quizapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizViewholder> {


    @NonNull
    @Override
    public QuizViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class QuizViewholder extends RecyclerView.ViewHolder{

        public QuizViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
