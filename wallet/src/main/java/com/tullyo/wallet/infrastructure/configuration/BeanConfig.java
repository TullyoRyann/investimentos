package com.tullyo.wallet.infrastructure.configuration;

import com.tullyo.wallet.domain.adapters.services.WalletService;
import com.tullyo.wallet.domain.ports.out.repositories.WalletRepositoryPort;
import com.tullyo.wallet.domain.ports.in.services.WalletServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  WalletServicePort walletService(WalletRepositoryPort walletRepositoryPort) {
    return new WalletService(walletRepositoryPort);
  }

}
