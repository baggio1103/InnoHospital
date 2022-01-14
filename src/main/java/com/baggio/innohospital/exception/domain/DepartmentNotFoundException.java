package com.baggio.innohospital.exception.domain;

public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException(String message){
        super(message);
    }

}
