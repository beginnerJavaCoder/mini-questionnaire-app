package com.example.form;

import com.example.entity.Answer;

import java.util.List;

public class QuestionnairePassingForm {
    private String username;
    private List<Answer> answers;

    public QuestionnairePassingForm() { }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
