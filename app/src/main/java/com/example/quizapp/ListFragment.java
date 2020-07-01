package com.example.quizapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private QuizListViewModel quizListViewModel;
    private QuizListAdapter adapter;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        adapter = new QuizListAdapter();
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        quizListViewModel = new ViewModelProvider(getActivity()).get(QuizListViewModel.class);

        quizListViewModel.getQuizListModelData()
                .observe(getViewLifecycleOwner(), new Observer<List<QuizListModel>>() {
                    @Override
                    public void onChanged(List<QuizListModel> quizListModels) {
                        adapter.setQuizListModels(quizListModels);
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}