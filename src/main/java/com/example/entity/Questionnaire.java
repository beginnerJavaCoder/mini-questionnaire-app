package com.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questionnaires")
public class Questionnaire extends Model {

    private String title;

    @OneToMany(mappedBy = "sourceQuestionnaire", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Question> questions;

    public Questionnaire() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
        question.setSourceQuestionnaire(this);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
        question.setSourceQuestionnaire(null);
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
