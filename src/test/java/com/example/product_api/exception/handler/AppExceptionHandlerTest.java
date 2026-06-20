package com.example.product_api.exception.handler;

import com.example.product_api.exception.AppException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.validation.*;
import jakarta.validation.constraints.NotNull;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

@Slf4j
class AppExceptionHandlerTest {
    ServletWebRequest webRequest;
    BindingResult bindingResult;
    MethodParameter methodParameter;
    AppExceptionHandler appExceptionHandler;
    Validator validator;
    @Data
    @AllArgsConstructor
    public static class TestClass {
        @NotNull
        String test;
        public String testMethod(String test){
            return test;
        }
    }

    @BeforeEach
    void setUp() throws NoSuchMethodException {
        webRequest = new ServletWebRequest(new MockHttpServletRequest());

        TestClass testTarget = new TestClass("Test");
        bindingResult = new org.springframework.validation.DataBinder(testTarget, "test").getBindingResult();
        bindingResult.addError(new ObjectError("Test", "Test Error"));
        bindingResult.rejectValue("test", "505", "Rejected value");

        Method method = TestClass.class.getMethod("testMethod", String.class);
        methodParameter = new MethodParameter(method, 0);

        appExceptionHandler = new AppExceptionHandler();
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    private void assertResponse(ResponseEntity<?> response, HttpStatus expectedStatus) {
        Assertions.assertNotNull(response);
        Assertions.assertEquals(expectedStatus, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        log.info("Response: {}", response);
    }

    @Test
    void shouldHandleMethodArgumentNotValid() {
        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(methodParameter, bindingResult);
        ResponseEntity<Object> response = appExceptionHandler.handleMethodArgumentNotValid(ex, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, webRequest);
        assertResponse(response, HttpStatus.BAD_REQUEST);
    }

    @Test
    void shouldHandleTypeMismatch() {
        TypeMismatchException ex = new TypeMismatchException("Tester", TestClass.class);
        ResponseEntity<Object> response = appExceptionHandler.handleTypeMismatch(ex, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, webRequest);
        assertResponse(response, HttpStatus.BAD_REQUEST);
    }



    @Test
    void shouldHandleMissingServletRequestPart() {
        MissingServletRequestPartException ex = new MissingServletRequestPartException("partName");
        ResponseEntity<Object> response = appExceptionHandler.handleMissingServletRequestPart(ex, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, webRequest);
        assertResponse(response, HttpStatus.BAD_REQUEST);
    }

    @Test
    void shouldHandleMissingServletRequestParameter() {
        MissingServletRequestParameterException ex = new MissingServletRequestParameterException("paramName", "String");
        ResponseEntity<Object> response = appExceptionHandler.handleMissingServletRequestParameter(ex, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, webRequest);
        assertResponse(response, HttpStatus.BAD_REQUEST);
    }

    @Test
    void shouldHandleMethodArgumentTypeMismatch() {
        MethodArgumentTypeMismatchException ex = new MethodArgumentTypeMismatchException(null, String.class, "Test", methodParameter, new RuntimeException("error"));
        ResponseEntity<Object> response = appExceptionHandler.handleMethodArgumentTypeMismatch(ex, webRequest);
        assertResponse(response, HttpStatus.BAD_REQUEST);
    }

    @Test
    void shouldHandleConstraintViolation() {
        Set<ConstraintViolation<TestClass>> violations = validator.validate(new TestClass(null));
        ConstraintViolationException ex = new ConstraintViolationException(violations);
        ResponseEntity<Object> response = appExceptionHandler.handleConstraintViolation(ex, webRequest);
        assertResponse(response, HttpStatus.BAD_REQUEST);
    }

    @Test
    void shouldHandleNoHandlerFoundException() {
        NoHandlerFoundException ex = new NoHandlerFoundException(HttpMethod.GET.name(), "/test", HttpHeaders.EMPTY);
        ResponseEntity<Object> response = appExceptionHandler.handleNoHandlerFoundException(ex, HttpHeaders.EMPTY, HttpStatus.NOT_FOUND, webRequest);
        assertResponse(response, HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldHandleAppException() {
        AppException ex = new AppException(HttpStatus.BAD_REQUEST, "Test App Exception");
        ResponseEntity<Object> response = appExceptionHandler.handleExampleException(ex, webRequest);
        assertResponse(response, HttpStatus.BAD_REQUEST);
    }

    @Test
    void shouldHandleAllExceptions() {
        Exception ex = new Exception("Generic Error");
        ResponseEntity<Object> response = appExceptionHandler.handleAll(ex, webRequest);
        assertResponse(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void shouldHandleHttpMediaTypeNotSupported() {
        HttpMediaTypeNotSupportedException ex = new HttpMediaTypeNotSupportedException("Unsupported Content Type");
        ResponseEntity<Object> response = appExceptionHandler.handleHttpMediaTypeNotSupported(ex, HttpHeaders.EMPTY, HttpStatus.UNSUPPORTED_MEDIA_TYPE, webRequest);
        assertResponse(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @Test
    void shouldHandleHttpRequestMethodNotSupported() {
        HttpRequestMethodNotSupportedException ex = new HttpRequestMethodNotSupportedException("GET", List.of("POST", "PUT"));
        ResponseEntity<Object> response = appExceptionHandler.handleHttpRequestMethodNotSupported(ex, HttpHeaders.EMPTY, HttpStatus.METHOD_NOT_ALLOWED, webRequest);
        assertResponse(response, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
