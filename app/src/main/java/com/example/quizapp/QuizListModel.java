package com.example.quizapp;

import com.google.firebase.firestore.DocumentId;

public class QuizListModel {

    @DocumentId
    private String quizId;
    private String name ,level, image, desc ,visibility;
    private long questions;

    public QuizListModel() {
    }

    public QuizListModel(String quizId, String name, String level, String image, String desc, String visibility, long questions) {
        this.quizId = quizId;
        this.name = name;
        this.level = level;
        this.image = image;
        this.desc = desc;
        this.visibility = visibility;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public long getQuestions() {
        return questions;
    }

    public void setQuestions(long questions) {
        this.questions = questions;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }
}
