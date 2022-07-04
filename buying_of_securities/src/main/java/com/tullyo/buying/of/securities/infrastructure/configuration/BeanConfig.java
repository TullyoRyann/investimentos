package com.tullyo.buying.of.securities.infrastructure.configuration;

import com.tullyo.buying.of.securities.domain.adapters.service.TitlePurchaseServiceImpl;
import com.tullyo.buying.of.securities.domain.ports.repositories.TitlePurchaseRepositoryPort;
import com.tullyo.buying.of.securities.domain.ports.services.TitlePurchaseServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  TitlePurchaseServicePort newTitlePurchaseService(TitlePurchaseRepositoryPort titlePurchaseRepositoryPort) {
    return new TitlePurchaseServiceImpl(titlePurchaseRepositoryPort);
  }

}
