package com.mallinapps.designdomain.common;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import com.mallinapps.designdomain.controller.api.common.ErrorResponse;
import com.mallinapps.designdomain.exception.EmptyNecessaryFieldException;
import com.mallinapps.designdomain.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(HttpServletRequest request, EntityNotFoundException notFoundException) {
        var error = createErrorResponse(notFoundException, HttpStatus.NOT_FOUND.toString(), request.getRequestURI());
        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyNecessaryFieldException.class)
    public ResponseEntity<ErrorResponse> handleEmptyNecessaryFieldException(HttpServletRequest request, EmptyNecessaryFieldException exception) {
        var error = createErrorResponse(exception, HttpStatus.BAD_REQUEST.toString(), request.getRequestURI());
        return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse createErrorResponse(RuntimeException exception, String code, String path) {
        return new ErrorResponse.ErrorResponseBuilder()
                .setCode(code)
                .setMessage(exception.getMessage())
                .setPath(path)
                .setTimestamp(LocalDateTime.now())
                .build();
    }

}
