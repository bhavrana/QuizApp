package com.fs.quiz.service;

import com.fs.quiz.domain.Question;
import com.fs.quiz.domain.QuizCategory;
import com.fs.quiz.repository.QuestionRepository;
import com.fs.quiz.repository.QuizCategoryRepository;
import com.fs.quiz.request.input.QuestionAnswerInput;
import com.fs.quiz.request.output.decorated.QuestionAnswerOutput;
import com.fs.quiz.request.output.decorated.QuestionOutput;
import com.fs.quiz.request.output.helper.QuestionAnswerOutputHelper;
import com.fs.quiz.request.output.helper.QuestionOutputHelper;
import com.fs.quiz.request.output.raw.QuestionAnswerOutputRaw;
import com.fs.quiz.request.output.raw.QuestionOutputRaw;
import com.fs.quiz.util.Constants;
import com.fs.quiz.validate.input.QuestionAnswerInputValidate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Question Service implementation
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizCategoryRepository quizCategoryRepository;
    private final QuestionOutputHelper questionOutputHelper;
    private final QuestionAnswerOutputHelper questionAnswerOutputHelper;
    private final QuestionAnswerInputValidate questionAnswerInputValidate;

    public QuestionServiceImpl(final QuestionRepository questionRepository,
                               QuizCategoryRepository quizCategoryRepository,
                               QuestionOutputHelper questionOutputHelper,
                               QuestionAnswerOutputHelper questionAnswerOutputHelper,
                               QuestionAnswerInputValidate questionAnswerInputValidate){
        this.questionRepository = questionRepository;
        this.quizCategoryRepository = quizCategoryRepository;
        this.questionOutputHelper = questionOutputHelper;
        this.questionAnswerOutputHelper = questionAnswerOutputHelper;
        this.questionAnswerInputValidate = questionAnswerInputValidate;
    }

    public QuestionOutput getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionOutputRaw> questionOutputRawList = new LinkedList<>();
        for(var question : questions) {
            QuestionOutputRaw questionOutputRaw = new QuestionOutputRaw(question.getId(), question.getQuestion());
            questionOutputRawList.add(questionOutputRaw);
        }
        QuestionOutput questionOutput = questionOutputHelper.getQuestionOutputInstance(questionOutputRawList);
        return questionOutput;
    }

    @Override
    public QuestionOutput getAllQuestionsForCategory(final String quizCategoryStr) {

        QuizCategory quizCategory = quizCategoryRepository.findQuizCategoryByCategoryName(quizCategoryStr.toLowerCase());
        List<Question> questions = questionRepository.findAllQuestionsByCategory(quizCategory.getId());
        List<QuestionOutputRaw> questionOutputRawList = new LinkedList<>();
        for(var question : questions) {
            QuestionOutputRaw questionOutputRaw = new QuestionOutputRaw(question.getId(), question.getQuestion());
            questionOutputRawList.add(questionOutputRaw);
        }
        QuestionOutput questionOutput = questionOutputHelper.getQuestionOutputInstance(questionOutputRawList);
        return questionOutput;
    }

    @Override
    public QuestionAnswerOutput questionAnswerCheck(QuestionAnswerInput questionAnswerInput) {

        //validate the input
        questionAnswerInputValidate.validateQuestionAnswerInput(questionAnswerInput);

        List<QuestionAnswerOutputRaw> questionAnswerOutputRawList = new LinkedList<>();
        Map<Long, String> questionAnswerMap = questionAnswerInput.getQuestionAnswerMap();

        for(Map.Entry<Long, String> entry : questionAnswerMap.entrySet()) {
            Question question = questionRepository.findById(entry.getKey()).get();
            QuestionAnswerOutputRaw questionAnswerOutputRaw = new QuestionAnswerOutputRaw();
            questionAnswerOutputRaw.setQuestion(question.getQuestion());
            questionAnswerOutputRaw.setQuestionId(question.getId());
            questionAnswerOutputRaw.setExpectedAnswer(question.getAnswer());
            questionAnswerOutputRaw.setGivenAnswer(entry.getValue());
            // check Answer
            if(question.getAnswer().equalsIgnoreCase(entry.getValue())) {
                questionAnswerOutputRaw.setResult(Constants.CORRECT);
            } else {
                questionAnswerOutputRaw.setResult(Constants.INCORRECT);
            }
            questionAnswerOutputRawList.add(questionAnswerOutputRaw);
        }

        QuestionAnswerOutput questionAnswerOutput = questionAnswerOutputHelper.getQuestionAnswerOutputInstance(questionAnswerOutputRawList);
        return questionAnswerOutput;
    }
}
