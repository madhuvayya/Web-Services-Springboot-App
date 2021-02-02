package com.hm.webservicesapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hm.webservicesapp.dto.ResponseDTO;

@RestControllerAdvice
public class WebServicesExceptionHandler {

    @ExceptionHandler(MachineImageException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(MachineImageException exception){
        ResponseDTO responseDTO = new ResponseDTO(400, "BAD REQUEST",exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InstanceException.class)
    public ResponseEntity<ResponseDTO> handleInstanceException(InstanceException exception){
        ResponseDTO responseDTO = new ResponseDTO(400, "BAD REQUEST",exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }
	
}
