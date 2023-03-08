package com.webservice.projetospring.exception.handler;

import com.webservice.projetospring.exception.DatabaseException;
import com.webservice.projetospring.exception.ResourceNotFoundException;
import com.webservice.projetospring.exception.errors.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice //intercepta as excecoes que acontecerem para que esse objeto faca o possivel tratamento
@AllArgsConstructor
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // meu metodo vai interceptar qualquer excecao desse tipo que for lancada e ira tratar
    public ResponseEntity<StandardError> resourceANotFoundException(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError standardError = new StandardError(LocalDateTime.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dataBaseException(DatabaseException e, HttpServletRequest request){
        String error = "Data base error";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError standardError = new StandardError(LocalDateTime.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }

}
