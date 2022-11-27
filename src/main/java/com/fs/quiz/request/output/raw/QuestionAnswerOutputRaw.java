package com.fs.quiz.request.output.raw;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class QuestionAnswerOutputRaw {

    private Long questionId;

    private String question;

    private String givenAnswer;

    private String ExpectedAnswer;

    private String result;
}
