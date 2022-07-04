package com.tullyo.buying.of.securities.infrastructure.adapters.repositories;

import com.tullyo.buying.of.securities.infrastructure.adapters.entities.TitlePurchaseEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SpringTitlePurchaseRepository extends CrudRepository<TitlePurchaseEntity, String> {

  TitlePurchaseEntity findByAmountPaid(String id);
}
