package com.example.service.impl;

import com.example.entity.Questionnaire;
import com.example.repository.QuestionnaireRepository;
import com.example.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireServiceImpl(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @Override
    public void delete(Integer id) {
        questionnaireRepository.deleteById(id);
    }

    @Override
    public List<Questionnaire> findAll() {
        return questionnaireRepository.findAll();
    }

    @Override
    public Questionnaire findById(Integer id) {
        return questionnaireRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Questionnaire questionnaire) {
        questionnaireRepository.save(questionnaire);
    }
}
