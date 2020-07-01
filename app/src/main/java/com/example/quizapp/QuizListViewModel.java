package com.example.quizapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class QuizListViewModel extends ViewModel implements FirebaseRepository.OnFirestoreTaskComplete {

    private MutableLiveData<List<QuizListModel>> quizListModelData = new MutableLiveData<>();

    FirebaseRepository firebaseRepository = new FirebaseRepository(this);

    public QuizListViewModel() {
        firebaseRepository.getQuizData();
    }

    @Override
    public void quizListDataAdded(List<QuizListModel> quizListModels) {
        quizListModelData.setValue(quizListModels);
    }

    @Override
    public void onError(Exception e) {

    }

    public LiveData<List<QuizListModel>> getQuizListModelData() {
        return quizListModelData;
    }
}
