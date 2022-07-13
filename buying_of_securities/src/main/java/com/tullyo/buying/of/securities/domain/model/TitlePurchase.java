package com.tullyo.buying.of.securities.domain.model;

import com.tullyo.buying.of.securities.infrastructure.adapters.entities.WalletEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TitlePurchase {

  private LocalDateTime monthOfPurchase;
  private BigDecimal amountPaid;
  private BigDecimal dividendValue;
  private Integer quantity;
  private Wallet wallet;

}
