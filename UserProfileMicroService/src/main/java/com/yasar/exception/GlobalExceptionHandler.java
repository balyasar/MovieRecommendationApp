package com.yasar.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

import static com.yasar.exception.ErrorType.*;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handlerRuntimeException(RuntimeException e) {
        ErrorType errorType = ErrorType.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(createMessage(errorType, e), errorType.getHttpStatus());
    }

    /**
     * ExceptionHandler -> Kendisine verilen Exception sınıfını dinlemeye başlar ve
     * eğer ilgili sınıf hata fırlatırsa onu yakalar.
     */

    @ExceptionHandler(UserProfileException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handlerSatisException(UserProfileException userProfileException) {
        return new ResponseEntity<>(createMessage(userProfileException.getErrorType(), userProfileException), userProfileException.getErrorType().getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> fields = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(x -> fields.add(x.getField() + " : " + x.getDefaultMessage()));
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code(999)
                .message("Girilen bilgiler eksik ya da yanlıştır.")
                .fields(fields)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ErrorMessage> handleMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        ErrorType errorType = BAD_REQUEST_ERROR;
        return new ResponseEntity<>(createMessage(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(InvalidFormatException.class)
    public final ResponseEntity<ErrorMessage> handleInvalidFormatException(
            InvalidFormatException exception) {
        ErrorType errorType = BAD_REQUEST_ERROR;
        return new ResponseEntity<>(createMessage(errorType, exception), errorType.getHttpStatus());
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(
            MethodArgumentTypeMismatchException exception) {

        ErrorType errorType = BAD_REQUEST_ERROR;
        return new ResponseEntity<>(createMessage(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(
            MissingPathVariableException exception) {

        ErrorType errorType = BAD_REQUEST_ERROR;
        return new ResponseEntity<>(createMessage(errorType, exception), errorType.getHttpStatus());
    }


    private ErrorMessage createMessage(ErrorType errorType, Exception exception) {
        log.error("Tum hatalarin gectigi ortak nokta : " + exception);
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }

}
