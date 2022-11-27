package com.fs.quiz.controller;

import com.fs.quiz.exception.QuestionException;
import com.fs.quiz.request.output.decorated.ExceptionOutput;
import com.fs.quiz.request.output.raw.ExceptionOutputRaw;
import com.fs.quiz.util.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvisor {

    @ExceptionHandler(QuestionException.class)
    public ResponseEntity<ExceptionOutput> handleNoOtpException(QuestionException ex){
        ExceptionOutputRaw exceptionOutputRaw = new ExceptionOutputRaw();
        exceptionOutputRaw.setMessage(ex.getMessage());
        exceptionOutputRaw.setStatus(Constants.INVALID_INPUT);
        ExceptionOutput response = new ExceptionOutput();
        response.setExceptionOutputRaw(exceptionOutputRaw);
        return ResponseEntity.ok(response);
    }
}