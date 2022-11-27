package com.fs.quiz.service;

import com.fs.quiz.request.input.QuestionAnswerInput;
import com.fs.quiz.request.output.decorated.QuestionAnswerOutput;
import com.fs.quiz.request.output.decorated.QuestionOutput;

import java.util.List;

/**
 *  Question Service Interface
 */
public interface QuestionService {
    QuestionOutput getAllQuestions();
    QuestionOutput getAllQuestionsForCategory(final String quizCategory);
    QuestionAnswerOutput questionAnswerCheck(QuestionAnswerInput questionAnswerInput);
}
