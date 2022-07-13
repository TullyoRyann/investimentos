package com.tullyo.wallet.infrastructure.adapters.outbound.repositories;

import com.tullyo.wallet.infrastructure.adapters.inbound.entities.WalletEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface WalletRepository extends CrudRepository<WalletEntity, String> {

}
