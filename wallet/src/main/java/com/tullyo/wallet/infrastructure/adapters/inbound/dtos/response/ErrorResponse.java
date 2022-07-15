package com.tullyo.wallet.infrastructure.adapters.inbound.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

  private String code;
  private String description;

}
