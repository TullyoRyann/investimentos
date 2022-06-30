package com.tullyo.wallet.infrastructure.adapters.repositories;

import com.tullyo.wallet.infrastructure.adapters.entities.WalletEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface WalletRepository extends CrudRepository<WalletEntity, String> {

}
