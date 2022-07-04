package com.tullyo.buying.of.securities.domain.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.math.BigDecimal;

public class AmountConverter implements DynamoDBTypeConverter<String, BigDecimal> {

  public static final BigDecimal HUNDRED = new BigDecimal(100);

  @Override
  public String convert(BigDecimal object) {
    return object.multiply(HUNDRED).longValue() + "";
  }

  @Override
  public BigDecimal unconvert(String value) {
    return new BigDecimal(value).divide(HUNDRED);
  }

}
