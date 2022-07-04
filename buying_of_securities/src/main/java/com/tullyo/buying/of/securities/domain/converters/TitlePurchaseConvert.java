package com.tullyo.buying.of.securities.domain.converters;

import com.tullyo.buying.of.securities.domain.dtos.request.TitlePurchaseRequest;
import com.tullyo.buying.of.securities.domain.model.TitlePurchase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class TitlePurchaseConvert {

  private final ModelMapper modelMapper;

  public TitlePurchase convertToSave(TitlePurchaseRequest titlePurchaseRequest) {
    TitlePurchase titlePurchase = modelMapper.map(titlePurchaseRequest, TitlePurchase.class);
    titlePurchase.setMonthOfPurchase(titlePurchaseRequest.getMonthOfPurchase().atTime(LocalTime.now()));
    return titlePurchase;
  }

}
