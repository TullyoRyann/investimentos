package com.tullyo.wallet.infrastructure.adapters.outbound.repositories.impl;

import com.tullyo.wallet.domain.model.Wallet;
import com.tullyo.wallet.domain.ports.out.repositories.WalletRepositoryPort;
import com.tullyo.wallet.infrastructure.adapters.inbound.entities.WalletEntity;
import com.tullyo.wallet.infrastructure.adapters.outbound.repositories.WalletRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@AllArgsConstructor
public class SpringWalletRepository implements WalletRepositoryPort {

  private final WalletRepository walletRepository;
  private final ModelMapper modelMapper;

  @Override
  public Wallet save(Wallet wallet) {
    WalletEntity walletEntity = modelMapper.map(wallet, WalletEntity.class);
    WalletEntity walletSaved = this.walletRepository.save(walletEntity);
    return modelMapper.map(walletSaved, Wallet.class);
  }

  @Override
  public Optional<Wallet> findById(String id) {
    Optional<WalletEntity> optional = walletRepository.findById(id);
    if(optional.isPresent()) {
      Wallet wallet = modelMapper.map(optional.get(), Wallet.class);
      return Optional.of(wallet);
    }

    return Optional.empty();
  }

  @Override
  public Iterable<Wallet> findAll() {
     return StreamSupport.stream(walletRepository.findAll().spliterator(), false)
        .collect(Collectors.toList())
        .stream()
        .map(walletEntity -> modelMapper.map(walletEntity, Wallet.class))
        .collect(Collectors.toList());
  }

  @Override
  public void deleteById(String id) {
    walletRepository.deleteById(id);
  }

  @Override
  public boolean existsById(String id) {
    return walletRepository.existsById(id);
  }

}
