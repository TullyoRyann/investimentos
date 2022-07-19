package com.tullyo.wallet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpMessageCode {

  REQUIRED_FIELD_VALIDATION("412.000"),
  GENERIC_INTERNAL_SERVER_ERROR("500.000");

  private String code;

}
