package com.fs.quiz.request.output.helper;

import com.fs.quiz.request.output.decorated.QuestionAnswerOutput;
import com.fs.quiz.request.output.decorated.QuestionOutput;
import com.fs.quiz.request.output.raw.QuestionAnswerOutputRaw;
import com.fs.quiz.request.output.raw.QuestionOutputRaw;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class QuestionAnswerOutputHelper {

    public QuestionAnswerOutput getQuestionAnswerOutputInstance(List<QuestionAnswerOutputRaw> questionAnswerOutputRawList) {
        QuestionAnswerOutput questionAnswerOutput = new QuestionAnswerOutput();
        questionAnswerOutput.setQuestionAnswerOutputRawList(questionAnswerOutputRawList);
        return questionAnswerOutput;
    }

}
