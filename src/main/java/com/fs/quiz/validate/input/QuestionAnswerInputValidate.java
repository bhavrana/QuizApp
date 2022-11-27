package com.fs.quiz.validate.input;

import com.fs.quiz.domain.Question;
import com.fs.quiz.exception.QuestionException;
import com.fs.quiz.repository.QuestionRepository;
import com.fs.quiz.request.input.QuestionAnswerInput;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class QuestionAnswerInputValidate {

    private final QuestionRepository questionRepository;


    public QuestionAnswerInputValidate(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void validateQuestionAnswerInput(final QuestionAnswerInput questionAnswerInput) {
        Map<Long, String> questionAnswerMap = questionAnswerInput.getQuestionAnswerMap();

        for(Map.Entry<Long, String> entry : questionAnswerMap.entrySet()) {
            Optional<Question> question = questionRepository.findById(entry.getKey());
            if(!question.isPresent()) {
                throw new QuestionException("Question not found for ID " + entry.getKey());
            }
        }
    }
}
