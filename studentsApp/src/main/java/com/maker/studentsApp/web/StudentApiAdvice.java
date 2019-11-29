package com.maker.studentsApp.web;

import com.maker.studentsApp.commons.StudentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class StudentApiAdvice {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<Void> handlerErrorStudentNotFoundException(StudentException studentEx) {
        log.error("Error Vnd - Student Exception - {0}", studentEx);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
