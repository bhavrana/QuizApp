package com.fs.quiz.request.output.raw;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExceptionOutputRaw {

    private String message;

    private String status;
}
