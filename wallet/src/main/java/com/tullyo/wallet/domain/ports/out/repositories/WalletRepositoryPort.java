package com.tullyo.wallet.domain.ports.out.repositories;

import com.tullyo.wallet.domain.model.Wallet;

import java.util.Optional;

public interface WalletRepositoryPort {

  Wallet save(Wallet wallet);
  Optional<Wallet> findById(String id);
  Iterable<Wallet> findAll();
  void deleteById(String id);
  boolean existsById(String id);

}
