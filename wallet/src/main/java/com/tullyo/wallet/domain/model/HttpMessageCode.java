package com.tullyo.wallet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpMessageCode {

  GENERIC_INTERNAL_SERVER_ERROR("500.000");

  private String code;

}
