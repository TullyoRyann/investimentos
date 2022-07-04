package com.tullyo.buying.of.securities.domain.dtos.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class TitlePurchaseRequest {

  private LocalDate monthOfPurchase;
  private BigDecimal amountPaid;
  private BigDecimal dividendValue;
  private Integer quantity;
  private WalletRequest wallet;

}
