package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer extends Model {

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question sourceQuestion;

    public Answer() { }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getSourceQuestion() {
        return sourceQuestion;
    }

    public void setSourceQuestion(Question sourceQuestion) {
        this.sourceQuestion = sourceQuestion;
    }
}
