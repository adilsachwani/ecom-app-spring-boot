package com.project.ecomapp.exception;

import com.project.ecomapp.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EcomExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorDto> handleServiceException(ServiceException ex){
        ErrorDto errorDto = ErrorDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .detailedMessage(ex.getDetailedMessage())
                .build();
        return new ResponseEntity<>(errorDto, HttpStatus.valueOf(errorDto.getCode()));
    }

}