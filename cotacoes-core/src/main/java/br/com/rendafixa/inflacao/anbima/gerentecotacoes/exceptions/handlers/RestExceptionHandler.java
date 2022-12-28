package br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.handlers;

import br.com.rendafixa.inflacao.anbima.gerentecotacoes.exceptions.errors.database.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException exception) {
        ExceptionDetails exceptionDetails = ExceptionDetails
                .Builder
                .newBuilder()
                .withTitle("Resource Not Found")
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withTimestamp(new Date().getTime())
                .withDetails(exception.getMessage())
                .withDevelopMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DeleteDatabaseException.class)
    public ResponseEntity<?> handlerDeleteDatabaseException(DeleteDatabaseException exception) {
        ExceptionDetails exceptionDetails = ExceptionDetails
                .Builder
                .newBuilder()
                .withTitle("The resource can't be deleted")
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withTimestamp(new Date().getTime())
                .withDetails(exception.getMessage())
                .withDevelopMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UpdateDatabaseException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(UpdateDatabaseException exception) {
        ExceptionDetails exceptionDetails = ExceptionDetails
                .Builder
                .newBuilder()
                .withTitle("The resource can't be updated")
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withTimestamp(new Date().getTime())
                .withDetails(exception.getMessage())
                .withDevelopMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SaveDataBaseException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(SaveDataBaseException exception) {
        ExceptionDetails exceptionDetails = ExceptionDetails
                .Builder
                .newBuilder()
                .withTitle("The resource can't be saved")
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withTimestamp(new Date().getTime())
                .withDetails(exception.getMessage())
                .withDevelopMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
