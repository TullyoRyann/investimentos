package com.tullyo.buying.of.securities.domain.ports.repositories;

import com.tullyo.buying.of.securities.domain.model.TitlePurchase;

import java.util.Optional;

public interface TitlePurchaseRepositoryPort {

  TitlePurchase save(TitlePurchase titlePurchase);
  Optional<TitlePurchase> get(String id);
  TitlePurchase findByAmountPaid(String id);

}
