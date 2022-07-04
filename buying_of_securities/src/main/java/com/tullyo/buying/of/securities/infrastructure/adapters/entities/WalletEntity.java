package com.tullyo.buying.of.securities.infrastructure.adapters.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@DynamoDBDocument
public class WalletEntity {

  @DynamoDBAttribute
  private String id;

  @DynamoDBAttribute
  private String title;

  @DynamoDBAttribute
  private String name;

}
