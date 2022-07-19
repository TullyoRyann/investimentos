package com.tullyo.wallet.infrastructure.configuration;

import com.tullyo.wallet.domain.model.HttpMessageCode;
import com.tullyo.wallet.infrastructure.adapters.inbound.dtos.response.ErrorResponse;
import com.tullyo.wallet.infrastructure.services.DictionaryService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler {

  private final DictionaryService dictionaryService;

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception ex){
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(dictionaryService.getMessage(HttpMessageCode.GENERIC_INTERNAL_SERVER_ERROR.getCode()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorResponse>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    List<ErrorResponse> errors = new ArrayList<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();

      ErrorResponse errorResponse = dictionaryService
          .getMessageWithFieldAndDescription(HttpMessageCode.REQUIRED_FIELD_VALIDATION.getCode(), fieldName, errorMessage);
      errors.add(errorResponse);
    });

    return ResponseEntity
        .status(HttpStatus.PRECONDITION_FAILED)
        .body(errors);
  }

}
