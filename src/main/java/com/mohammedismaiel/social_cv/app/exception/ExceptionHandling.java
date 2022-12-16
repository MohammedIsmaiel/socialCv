package com.mohammedismaiel.social_cv.app.exception;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import javax.persistence.NoResultException;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mohammedismaiel.social_cv.app.domain.HttpResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandling implements ErrorController {

    private static final String METHOULD_IS_NOT_ALLOWED = "This request method is not allowed on this endpoint allowed is : '%s'";
    private static final String INTERNAL_SERVER_ERROR_MSG = "An error ocured while proccssing this request";
    private static final String ERROR_PROCCESSING_FILE = "An error ocured while proccssing File";
    private static final String THIS_RESOURCE_IS_NOT_FOUND = "This resource is not found";
    private static final String ERROR_PATH = "/error";

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<HttpResponse> noHandlerFoundException(NoHandlerFoundException noHandlerFoundException) {
        return createResponse(HttpStatus.BAD_REQUEST, "this page was not found :(");
    }

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<HttpResponse> emailExistException(EmailExistException emailExistException) {
        return createResponse(HttpStatus.BAD_REQUEST, emailExistException.getMessage());
    }

    @ExceptionHandler(UsernameExistException.class)
    public ResponseEntity<HttpResponse> usernameExistException(UsernameExistException usernameExistException) {
        return createResponse(HttpStatus.BAD_REQUEST, usernameExistException.getMessage());
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<HttpResponse> emailNotFoundException(EmailNotFoundException emailNotFoundException) {
        return createResponse(HttpStatus.BAD_REQUEST, emailNotFoundException.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<HttpResponse> usernameNotFoundException(UserNotFoundException userNotFoundException) {
        return createResponse(HttpStatus.BAD_REQUEST, userNotFoundException.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<HttpResponse> httpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
        HttpMethod supportedMethods = Objects
                .requireNonNull(httpRequestMethodNotSupportedException.getSupportedHttpMethods()).iterator().next();
        return createResponse(HttpStatus.METHOD_NOT_ALLOWED, String.format(METHOULD_IS_NOT_ALLOWED, supportedMethods));
    }

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<HttpResponse> notFoundException(NoResultException noResultException) {
        return createResponse(HttpStatus.NOT_FOUND, noResultException.getMessage().toUpperCase());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<HttpResponse> iOException(IOException ioException) {
        log.error("error is : " + ioException.getMessage().toUpperCase());
        return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_PROCCESSING_FILE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> internalServerError(Exception exception) {
        log.error("error is : " + exception.getMessage().toUpperCase());
        return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MSG);
    }

    @RequestMapping(ERROR_PATH)
    public ResponseEntity<HttpResponse> notFound404() {
        return createResponse(HttpStatus.NOT_FOUND, THIS_RESOURCE_IS_NOT_FOUND);
    }

    // private methods
    private ResponseEntity<HttpResponse> createResponse(HttpStatus httpStatus, String message) {
        HttpResponse httpResponse = new HttpResponse(httpStatus.value(), httpStatus,
                httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase(), new Date());
        return new ResponseEntity<>(httpResponse, httpStatus);
    }
}
