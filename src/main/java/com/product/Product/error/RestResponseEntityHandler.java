package com.product.Product.error;

import com.product.Product.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TitleNotFoundException.class)
    public ResponseEntity<ErrorMessage> TitleNotFoundException(TitleNotFoundException titleNotFoundException, WebRequest webRequest){
        System.out.println("inside rest response handler");
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, titleNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
