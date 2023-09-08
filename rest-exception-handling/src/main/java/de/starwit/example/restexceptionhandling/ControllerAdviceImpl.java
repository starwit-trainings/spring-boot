package de.starwit.example.restexceptionhandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceImpl extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { NumberFormatException.class })
    protected ResponseEntity<Object> handleIllegalArguments(NumberFormatException ex, WebRequest request) {
        String paramA = request.getParameter("a");
        String paramB = request.getParameter("b");
        String body = String.format("You supplied the following parameters: a=%s, b=%s<p>They must both be valid String representations of an integer!", paramA, paramB);
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
