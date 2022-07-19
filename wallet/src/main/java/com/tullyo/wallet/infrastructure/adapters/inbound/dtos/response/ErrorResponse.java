package com.tullyo.wallet.infrastructure.adapters.inbound.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

  private String code;
  private String field;
  private String description;

}
