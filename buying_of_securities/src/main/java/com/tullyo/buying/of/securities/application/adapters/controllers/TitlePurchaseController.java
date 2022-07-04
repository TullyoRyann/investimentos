package com.tullyo.buying.of.securities.application.adapters.controllers;

import com.tullyo.buying.of.securities.domain.converters.TitlePurchaseConvert;
import com.tullyo.buying.of.securities.domain.dtos.request.TitlePurchaseRequest;
import com.tullyo.buying.of.securities.domain.dtos.response.TitlePurchaseResponse;
import com.tullyo.buying.of.securities.domain.model.TitlePurchase;
import com.tullyo.buying.of.securities.domain.ports.services.TitlePurchaseServicePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/securities")
@RequiredArgsConstructor
public class TitlePurchaseController {

  private final TitlePurchaseServicePort titlePurchaseServicePort;
  private final TitlePurchaseConvert titlePurchaseConvert;
  private final ModelMapper modelMapper;

  @PostMapping
  public ResponseEntity<TitlePurchaseResponse> save(@RequestBody TitlePurchaseRequest titlePurchaseRequest) {
    TitlePurchase titlePurchase = titlePurchaseConvert.convertToSave(titlePurchaseRequest);
    TitlePurchase titlePurchaseSave = titlePurchaseServicePort.save(titlePurchase);
    TitlePurchaseResponse titlePurchaseResponse = modelMapper.map(titlePurchaseSave, TitlePurchaseResponse.class);
    return ResponseEntity.status(HttpStatus.CREATED).body(titlePurchaseResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TitlePurchaseResponse> get(@PathVariable("id") String id) {
    return titlePurchaseServicePort.get(id).stream()
        .map(titlePurchase -> modelMapper.map(titlePurchase, TitlePurchaseResponse.class))
        .map(carteiraResponse -> ResponseEntity.ok(carteiraResponse))
        .findFirst()
        .orElse(ResponseEntity.notFound().build());
  }

}
