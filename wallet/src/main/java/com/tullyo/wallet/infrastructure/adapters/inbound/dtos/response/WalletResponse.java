package com.tullyo.wallet.infrastructure.adapters.inbound.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletResponse {

  private String id;
  private String name;
  private String segment;
  private String type;

}
