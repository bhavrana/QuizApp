package com.fs.quiz.request.output.decorated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fs.quiz.request.output.raw.QuestionAnswerOutputRaw;
import com.fs.quiz.request.output.raw.QuestionOutputRaw;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Setter
public class QuestionAnswerOutput {

    @JsonProperty("Result")
    private List<QuestionAnswerOutputRaw> questionAnswerOutputRawList = new LinkedList<>();
}
