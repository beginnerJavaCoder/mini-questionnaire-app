package com.example.controller;

import com.example.entity.Questionnaire;
import com.example.form.QuestionnaireForm;
import com.example.form.QuestionnairePassingForm;
import com.example.service.QuestionnaireService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/questionnaires")
public class QuestionnaireRestController {

    private final QuestionnaireService questionnaireService;
    private final UserService userService;

    @Autowired
    public QuestionnaireRestController(QuestionnaireService questionnaireService,
                                       UserService userService) {
        this.questionnaireService = questionnaireService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Questionnaire>> getAllQuestionnaires() {
        List<Questionnaire> questionnaires = questionnaireService.findAll();

        if (questionnaires == null || questionnaires.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(questionnaires, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Questionnaire> getQuestionnaire(@PathVariable Integer id) {
        Questionnaire questionnaire = questionnaireService.findById(id);

        return questionnaire == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(questionnaire, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createQuestionnaire(@RequestBody QuestionnaireForm form) {
        Questionnaire questionnaire = form.composeQuestionnaire();
        questionnaireService.save(questionnaire);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteQuestionnaire(@PathVariable Integer id) {
        Questionnaire questionnaire = questionnaireService.findById(id);

        if (questionnaire == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        questionnaireService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateQuestionnaire(@PathVariable Integer id,
                                                 @RequestBody QuestionnaireForm form) {
        Questionnaire questionnaire = form.composeQuestionnaire();
        questionnaire.setId(id);
        questionnaireService.save(questionnaire);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/passing")
    public ResponseEntity<?> passQuestionnaire(@RequestBody QuestionnairePassingForm form) {
        userService.saveAnswers(form.getUsername(), form.getAnswers());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
