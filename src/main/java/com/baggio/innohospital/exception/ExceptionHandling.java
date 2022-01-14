package com.baggio.innohospital.exception;


import com.baggio.innohospital.data.HttpResponse;
import com.baggio.innohospital.exception.domain.DepartmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = DepartmentNotFoundException.class)
    public ResponseEntity<HttpResponse> handleDepartmentDoesNotExistException(DepartmentNotFoundException departmentNotFoundException) {
        return createHttpResponse(BAD_REQUEST, departmentNotFoundException.getMessage());
    }

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus status, String message) {
        return new ResponseEntity<>(new HttpResponse(status.value(), status, status.getReasonPhrase().toUpperCase(),
                message.toUpperCase()), status);
    }

}