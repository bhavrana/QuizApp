package com.fs.quiz.controller;

import com.fs.quiz.request.input.QuestionAnswerInput;
import com.fs.quiz.request.output.decorated.QuestionAnswerOutput;
import com.fs.quiz.request.output.decorated.QuestionOutput;
import com.fs.quiz.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Question Controller class
 */
@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionOutput> getAllQuestions(){
        QuestionOutput questionOutput = questionService.getAllQuestions();
        return ResponseEntity.status(HttpStatus.OK).body(questionOutput);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/{category}")
    public ResponseEntity<QuestionOutput> getAllQuestionsForCategory(@PathVariable(name = "category", required = true) String quizCategory){
        QuestionOutput questionOutput = questionService.getAllQuestionsForCategory(quizCategory);
        return ResponseEntity.status(HttpStatus.OK).body(questionOutput);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionAnswerOutput> questionAnswerCheck(@RequestBody(required = true) QuestionAnswerInput questionAnswerInput) {
        QuestionAnswerOutput questionAnswerOutput = questionService.questionAnswerCheck(questionAnswerInput);
        return ResponseEntity.status(HttpStatus.OK).body(questionAnswerOutput);
    }
}
