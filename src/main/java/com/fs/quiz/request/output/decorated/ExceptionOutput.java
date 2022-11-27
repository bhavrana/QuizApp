package com.fs.quiz.request.output.decorated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fs.quiz.request.output.raw.ExceptionOutputRaw;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExceptionOutput {
    @JsonProperty("Error")
    private ExceptionOutputRaw exceptionOutputRaw;

}
