package com.example.quizapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizViewholder> {

    private List<QuizListModel> quizListModels;

    public void setQuizListModels(List<QuizListModel> quizListModels) {
        this.quizListModels = quizListModels;
    }

    @NonNull
    @Override
    public QuizViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item,parent,false);

        return new QuizViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewholder holder, int position) {
        holder.listTitle.setText(quizListModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (quizListModels == null)
            return 0;
        return quizListModels.size();
    }

    class QuizViewholder extends RecyclerView.ViewHolder{

        private ImageView listImage;
        private TextView listTitle;
        private TextView listDesc;
        private TextView listLevel;
        private Button listBtn;

        public QuizViewholder(@NonNull View itemView) {
            super(itemView);

            listImage = itemView.findViewById(R.id.list_imageView);
            listTitle = itemView.findViewById(R.id.list_title);
            listDesc = itemView.findViewById(R.id.list_desc);
            listLevel = itemView.findViewById(R.id.list_difficulty);
            listBtn = itemView.findViewById(R.id.list_start_quiz_btn);
        }
    }
}
