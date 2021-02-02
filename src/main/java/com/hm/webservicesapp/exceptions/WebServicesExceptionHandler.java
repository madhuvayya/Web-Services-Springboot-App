package com.hm.webservicesapp.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebServicesExceptionHandler {

    @ExceptionHandler(MachineImageException.class)
    public String handleEmployeePayrollException(MachineImageException exception){
        return exception.getMessage();
    }
	
}
