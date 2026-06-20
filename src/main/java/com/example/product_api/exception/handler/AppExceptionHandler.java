package com.example.product_api.exception.handler;

import com.bluntsoftware.demo.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Slf4j
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message, List<String> errors, Exception ex, HttpHeaders headers, WebRequest request) {
        AppError appError = AppError.builder()
                .code(status.value())
                .status(status)
                .message(message)
                .errors(errors)
                .build();
        return handleExceptionInternal(ex, appError, headers, status, request);
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message, String error, Exception ex, HttpHeaders headers, WebRequest request) {
        return buildResponseEntity(status, message, List.of(error), ex, headers, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.info("{} - handleMethodArgumentNotValid", ex.getClass().getName());
        return buildBindingResultResponseEntity(ex.getBindingResult(), headers, status, ex, request);
    }

    private ResponseEntity<Object> buildBindingResultResponseEntity(org.springframework.validation.BindingResult bindingResult, HttpHeaders headers, HttpStatusCode status, Exception ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));
        bindingResult.getGlobalErrors().forEach(error -> errors.add(error.getObjectName() + ": " + error.getDefaultMessage()));
        return buildResponseEntity(HttpStatus.valueOf(status.value()), ex.getLocalizedMessage(), errors, ex, headers, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.info("{} - handleTypeMismatch", ex.getClass().getName());
        String error = ex.getValue() + " value for " + ex.getPropertyName() + " should be of type " + ex.getRequiredType();
        return buildResponseEntity(HttpStatus.valueOf(status.value()), ex.getLocalizedMessage(), error, ex, headers, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.info(ex.getClass().getName());
        String error = ex.getRequestPartName() + " part is missing";
        return buildResponseEntity(HttpStatus.valueOf(status.value()), ex.getLocalizedMessage(), error, ex, headers, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.info(ex.getClass().getName());
        String error = ex.getParameterName() + " parameter is missing";
        return buildResponseEntity(HttpStatus.valueOf(status.value()), ex.getLocalizedMessage(), error, ex, headers, request);
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        log.info(ex.getClass().getName());
        String error = ex.getName() + " should be of type " + Objects.requireNonNull(ex.getRequiredType()).getName();
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error, ex, new HttpHeaders(), request);
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        log.info(ex.getClass().getName());
        List<String> errors = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .toList();
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors, ex, new HttpHeaders(), request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.info(ex.getClass().getName());
        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        return buildResponseEntity(HttpStatus.valueOf(status.value()), ex.getLocalizedMessage(), error, ex, headers, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.info(ex.getClass().getName());
        String error = ex.getMethod() + " method is not supported for this request. Supported methods are " +
                Objects.requireNonNull(ex.getSupportedHttpMethods());
        return buildResponseEntity(HttpStatus.valueOf(status.value()), ex.getLocalizedMessage(), error, ex, headers, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.info(ex.getClass().getName());
        String error = ex.getContentType() + " media type is not supported. Supported media types are " +
                ex.getSupportedMediaTypes();
        return buildResponseEntity(HttpStatus.valueOf(status.value()), ex.getLocalizedMessage(), error, ex, headers, request);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        log.error("Unhandled exception occurred", ex);
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred", ex, new HttpHeaders(), request);
    }

    @ExceptionHandler({ AppException.class })
    public ResponseEntity<Object> handleExampleException(AppException ex, WebRequest request) {
        log.error("AppException: {}", ex.getAppError().getMessage());
        return new ResponseEntity<>(ex.getAppError(), new HttpHeaders(), ex.getAppError().getStatus());
    }

}
