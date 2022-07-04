package com.tullyo.buying.of.securities.domain.ports.services;

import com.tullyo.buying.of.securities.domain.model.TitlePurchase;

import java.util.Optional;

public interface TitlePurchaseServicePort {

  TitlePurchase save(TitlePurchase titlePurchase);
  Optional<TitlePurchase> get(String id);

}
