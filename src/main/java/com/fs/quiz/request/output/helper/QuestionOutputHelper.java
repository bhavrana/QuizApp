package com.fs.quiz.request.output.helper;

import com.fs.quiz.request.output.decorated.QuestionOutput;
import com.fs.quiz.request.output.raw.QuestionOutputRaw;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class QuestionOutputHelper {

    public QuestionOutput getQuestionOutputInstance(List<QuestionOutputRaw> questionOutputRawList) {
        QuestionOutput questionOutput = new QuestionOutput();
        questionOutput.setQuestionOutputRawList(questionOutputRawList);
        return questionOutput;
    }
}
