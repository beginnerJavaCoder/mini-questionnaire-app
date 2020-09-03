package com.example.service;

import com.example.entity.Questionnaire;

import java.util.List;

public interface QuestionnaireService {

    List<Questionnaire> findAll();

    Questionnaire findById(Integer id);

    void save(Questionnaire questionnaire);

    void delete(Integer id);
}
