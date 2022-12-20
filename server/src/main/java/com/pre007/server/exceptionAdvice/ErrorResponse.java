package com.pre007.server.exceptionAdvice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {
    private List<FieldError> fieldErrors;   //Dto 필드에서 Validation 이 실패했을때의 에러 정보(MethodArgumentNotValidException)를 담는 변수; Custom FieldError 사용
    private List<ConstraintViolationError> constraintViolationErrors;  //URI 변수 값에서 Validation 이 실패했을때의 에러 정보(ConstraintViolationException)를 담는 변수; Custom ConstraintViolationError 사용

    //ErrorResponse.class 내부에서만 사용하기 위한 생성자
    private ErrorResponse(List<FieldError> fieldErrors, List<ConstraintViolationError> constraintViolationErrors) {
        this.fieldErrors = fieldErrors;
        this.constraintViolationErrors = constraintViolationErrors;
    }

    public static ErrorResponse of(MethodArgumentNotValidException e){
        return new ErrorResponse(FieldError.of(e), null);
    }

    public static ErrorResponse of(ConstraintViolationException e){
        return new ErrorResponse(null, ConstraintViolationError.of(e));
    }

    @Getter
    @AllArgsConstructor
    public static class FieldError {
        //기존 Validation.FieldError 의 정보를 받을 Custom FieldError

        private String field;   //Validation.FieldError 의 String field 를 받을 변수
        private Object rejectedValue; //Validation.FieldError 의 Object rejectedValue 를 받을 변수
        private String reason;  //Dto 클래스 필드마다 설정해둔 Validation 실패 시 출력하는 메세지를 받을 변수

        public static List<FieldError> of(MethodArgumentNotValidException e){ //MethodArgumentNotValidException : @Valid 애너테이션이 달린 요소의 Validation 이 실패했을때를 다루는 예외 클래스 (extends BindException)
            final List<org.springframework.validation.FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
            //BindException.getBindingResult() : BindingException 을 하나의 묶음(객체)로 반환하는 메서드
            //Errors.getFieldErrors() : 묶여있는 예외 정보를 각각의 필드로 구분하는 메서드

            List<FieldError> errors =
                    fieldErrors.stream()
                            .map(error -> new FieldError(
                                    error.getField(),   //Request Dto 에서 Validation 을 실패한 필드가 무엇인지 안내
                                    error.getRejectedValue(),   //Request Dto 에서 Validation 을 실패한 입력(요청) 값이 무엇인지 안내
                                    error.getDefaultMessage())) //Request Dto 의 각 필드에 설정해둔 Validation 이 실패하면 출력하는 메세지
                            .collect(Collectors.toList());

            return errors;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class ConstraintViolationError{
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        public static List<ConstraintViolationError> of(ConstraintViolationException e){
            Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

            List<ConstraintViolationError> errors =
                    constraintViolations.stream()
                            .map(error -> new ConstraintViolationError(
                                    error.getPropertyPath().toString(),
                                    error.getInvalidValue().toString(),
                                    error.getMessage()))
                            .collect(Collectors.toList());

            return errors;
        }
    }
}

/*
Exception Handler Method 만들기
1. 핸들링할 예외의 이름으로 내부 클래스를 생성한다.
2. (1)에서 생성한 클래스명의 필드를 ErrorResponse.class 에 생성하고, 내부 생성자를 만든다.
3. (1)에서 생성한 내부 클래스 안에 해당 Exception 으로 추출하고 싶은 정보들을 필드로 생성한다. (해당 Exception 에서 추출할 수 있는 정보여야 한다.)
4. (1)에서 생성한 내부 클래스 안에 of() 메서드를 만든다. (반환형: List<해당 Exception>)
5. 해당 Exception 을 다루는 내부 클래스를 매개변수로 하는 ErrorResponse.of() 메서드를 만들어 사용한다.
 */
