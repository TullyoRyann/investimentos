package com.tullyo.wallet.infrastructure.configuration;

import com.tullyo.wallet.domain.model.HttpMessageCode;
import com.tullyo.wallet.infrastructure.adapters.inbound.dtos.response.ErrorResponse;
import com.tullyo.wallet.infrastructure.services.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
