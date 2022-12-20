package com.pre007.server.exceptionAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

// @RestControllerAdvice = @ControllerAdvice + @ResponseBody
// @ControllerAdvice : 모든 Controller 에서 발생하는 예외를 잡아주는 애너테이션
// @ResponseBody : 응답 리턴을 ResponseEntity 클래스로 래핑하지 않아도 JSON 형식의 Response Body 알아서 변환해주는 애너테이션
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler // 예외 처리를 다루는 핸들러 메서드로 지정하는 애너테이션
    @ResponseStatus(HttpStatus.BAD_REQUEST) // ResponseEntity 으로 묶지않고 HttpStatus 를 표현하는 애너테이션
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        final ErrorResponse errorResponse = ErrorResponse.of(e);

        return errorResponse;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e){
        final ErrorResponse errorResponse = ErrorResponse.of(e);

        return errorResponse;
    }
}

/*
Exception Handler Method 만들기
1. 핸들링할 예외를 정한다.
2. 해당 예외에 대한 @ExceptionHandler 애너테이션을 붙인 메서드를 만든다.
3. ErrorResponse.class 에 해당 Exception 에 대한 정보를 담아내도록 구현한다. //ErrorResponse.class 에서 자세히 설명
4. 응답하는 Response 에 ErrorResponse 형의 반환값으로 정보를 담고, @ResponseStatus 으로 HttpStatus 를 담아서 반환한다.
 */
