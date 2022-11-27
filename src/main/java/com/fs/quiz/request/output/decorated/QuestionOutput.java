package com.fs.quiz.request.output.decorated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fs.quiz.request.output.raw.QuestionOutputRaw;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class QuestionOutput {

    @JsonProperty("Questions")
    private List<QuestionOutputRaw> questionOutputRawList = new LinkedList<>();
}
