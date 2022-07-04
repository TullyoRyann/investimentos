package com.tullyo.buying.of.securities.domain.dtos.response;

import com.tullyo.buying.of.securities.infrastructure.adapters.entities.WalletEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class TitlePurchaseResponse {

  private String id;
  private LocalDateTime monthOfPurchase;
  private BigDecimal amountPaid;
  private BigDecimal dividendValue;
  private Integer quantity;
  private WalletResponse wallet;

}
