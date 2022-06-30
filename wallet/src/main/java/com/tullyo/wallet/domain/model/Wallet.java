package com.tullyo.wallet.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Wallet {

  private String id;

  private String title;

  private String name;

  private String segment;

  private String type;

}
