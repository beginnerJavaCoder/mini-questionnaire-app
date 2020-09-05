package com.example.form;

import com.example.entity.Question;
import com.example.entity.Questionnaire;

import java.util.List;

public class QuestionnaireForm {

    private String title;
    private List<Question> questions;

    public QuestionnaireForm() { }

    public Questionnaire composeQuestionnaire() {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setTitle(title);

        for (Question q : questions) {
            questionnaire.addQuestion(q);
        }

        return questionnaire;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
