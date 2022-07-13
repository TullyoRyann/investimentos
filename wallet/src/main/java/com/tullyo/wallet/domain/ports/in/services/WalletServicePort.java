package com.tullyo.wallet.domain.ports.in.services;

import com.tullyo.wallet.domain.model.Wallet;

import java.util.Optional;

public interface WalletServicePort {

  Wallet save(Wallet wallet);
  Wallet update();
  Optional<Wallet> get(String id);
  Iterable<Wallet> listAll();
  void delete(String id);
  boolean existWallet(String id);

}
