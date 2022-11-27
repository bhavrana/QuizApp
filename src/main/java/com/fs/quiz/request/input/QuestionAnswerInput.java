package com.fs.quiz.request.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
public class QuestionAnswerInput {

    private Map<Long, String> questionAnswerMap = new HashMap<>();
}
