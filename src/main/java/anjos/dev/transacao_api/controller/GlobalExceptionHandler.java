package anjos.dev.transacao_api.controller;

import anjos.dev.transacao_api.infractructure.exceptions.unprocessableEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(unprocessableEntity.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<String> handleUnprocessableEntity(unprocessableEntity ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Error" + ex.getMessage());
    }

    @ExceptionHandler(unprocessableEntity.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleUnprocessableEntity(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" + ex.getMessage());
    }
}
