package com.tullyo.wallet.infrastructure.services;

import com.tullyo.wallet.domain.model.HttpMessageCode;
import com.tullyo.wallet.infrastructure.adapters.inbound.dtos.response.ErrorResponse;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictionaryService {

  private final MessageSource messageSource;

  public ErrorResponse getMessage(@NotNull String key) {
    try {
      return ErrorResponse.builder()
          .code(key)
          .description(this.messageSource.getMessage(key, null, LocaleContextHolder.getLocale()))
          .build();
    } catch (Exception e) {
      return ErrorResponse.builder()
          .code(HttpMessageCode.GENERIC_INTERNAL_SERVER_ERROR.getCode())
          .description(this.messageSource.getMessage(HttpMessageCode.GENERIC_INTERNAL_SERVER_ERROR.getCode(), null, LocaleContextHolder.getLocale()))
          .build();
    }
  }

}
