package com.tullyo.buying.of.securities.infrastructure.adapters.repositories.impl;

import com.tullyo.buying.of.securities.domain.model.TitlePurchase;
import com.tullyo.buying.of.securities.domain.ports.repositories.TitlePurchaseRepositoryPort;
import com.tullyo.buying.of.securities.infrastructure.adapters.entities.TitlePurchaseEntity;
import com.tullyo.buying.of.securities.infrastructure.adapters.repositories.SpringTitlePurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TitlePurchaseRepository implements TitlePurchaseRepositoryPort {

  private final SpringTitlePurchaseRepository titlePurchaseRepository;
  private final ModelMapper modelMapper;

  @Override
  public TitlePurchase save(TitlePurchase titlePurchase) {
    TitlePurchaseEntity entity = modelMapper.map(titlePurchase, TitlePurchaseEntity.class);
    TitlePurchaseEntity entitySaved = titlePurchaseRepository.save(entity);
    return modelMapper.map(entitySaved, TitlePurchase.class);
  }

  @Override
  public Optional<TitlePurchase> get(String id) {
    Optional<TitlePurchaseEntity> optional = titlePurchaseRepository.findById(id);
    if(optional.isPresent()) {
      TitlePurchase titlePurchase = modelMapper.map(optional.get(), TitlePurchase.class);
      return Optional.of(titlePurchase);
    }

    return Optional.empty();
  }

  @Override
  public TitlePurchase findByAmountPaid(String id) {
    TitlePurchaseEntity entity = titlePurchaseRepository.findByAmountPaid(id);
    return modelMapper.map(entity, TitlePurchase.class);
  }

}
