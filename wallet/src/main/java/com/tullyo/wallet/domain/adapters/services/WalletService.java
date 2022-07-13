package com.tullyo.wallet.domain.adapters.services;

import com.tullyo.wallet.domain.model.Wallet;
import com.tullyo.wallet.domain.ports.out.repositories.WalletRepositoryPort;
import com.tullyo.wallet.domain.ports.in.services.WalletServicePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class WalletService implements WalletServicePort {

  private final WalletRepositoryPort walletRepositoryPort;

  @Override
  public Wallet save(Wallet wallet) {
    return walletRepositoryPort.save(wallet);
  }

  @Override
  public Wallet update() {
    return null;
  }

  @Override
  public Optional<Wallet> get(String id) {
    return walletRepositoryPort.findById(id);
  }

  @Override
  public Iterable<Wallet> listAll() {
    return walletRepositoryPort.findAll();
  }

  @Override
  public void delete(String id) {
    walletRepositoryPort.deleteById(id);
  }

  @Override
  public boolean existWallet(String id) {
    return walletRepositoryPort.existsById(id);
  }

}
