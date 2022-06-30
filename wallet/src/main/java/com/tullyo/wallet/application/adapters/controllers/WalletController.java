package com.tullyo.wallet.application.adapters.controllers;

import com.tullyo.wallet.domain.dtos.request.WalletRequest;
import com.tullyo.wallet.domain.dtos.response.WalletResponse;
import com.tullyo.wallet.domain.model.Wallet;
import com.tullyo.wallet.domain.ports.services.WalletServicePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {

  private final WalletServicePort walletServicePort;
  private final ModelMapper modelMapper;

  @PostMapping
  public ResponseEntity<WalletResponse> save(@RequestBody WalletRequest walletRequest) {
    Wallet wallet = modelMapper.map(walletRequest, Wallet.class);
    Wallet walletSaved = walletServicePort.save(wallet);
    WalletResponse walletResponse = modelMapper.map(walletSaved, WalletResponse.class);
    return ResponseEntity.status(HttpStatus.CREATED).body(walletResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<WalletResponse> get(@PathVariable("id") String id) {
    return walletServicePort.get(id).stream()
        .map(wallet -> modelMapper.map(wallet, WalletResponse.class))
        .map(walletResponse -> ResponseEntity.ok(walletResponse))
        .findFirst()
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<WalletResponse>> findAll() {
    List<WalletResponse> response = StreamSupport.stream(walletServicePort.listAll().spliterator(), false)
        .collect(Collectors.toList())
        .stream()
        .map(wallet -> modelMapper.map(wallet, WalletResponse.class))
        .collect(Collectors.toList());

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    if(walletServicePort.existWallet(id)) {
      walletServicePort.delete(id);
      return ResponseEntity.noContent().build();
    }

    return  ResponseEntity.notFound().build();
  }

}
