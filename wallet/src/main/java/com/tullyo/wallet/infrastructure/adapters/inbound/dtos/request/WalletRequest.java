package com.tullyo.wallet.infrastructure.adapters.inbound.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletRequest {

  private String title;
  private String name;
  private String segment;
  private String type;

}
