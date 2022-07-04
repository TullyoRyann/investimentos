package com.tullyo.buying.of.securities.domain.adapters.service;

import com.tullyo.buying.of.securities.domain.model.TitlePurchase;
import com.tullyo.buying.of.securities.domain.ports.repositories.TitlePurchaseRepositoryPort;
import com.tullyo.buying.of.securities.domain.ports.services.TitlePurchaseServicePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class TitlePurchaseServiceImpl implements TitlePurchaseServicePort {

  private final TitlePurchaseRepositoryPort titlePurchaseRepositoryPort;

  @Override
  public TitlePurchase save(TitlePurchase titlePurchase) {
    return titlePurchaseRepositoryPort.save(titlePurchase);
  }

  @Override
  public Optional<TitlePurchase> get(String id) {
    TitlePurchase titlePurchase = titlePurchaseRepositoryPort.findByAmountPaid(id);
    return Optional.of(titlePurchase);
  }

}
