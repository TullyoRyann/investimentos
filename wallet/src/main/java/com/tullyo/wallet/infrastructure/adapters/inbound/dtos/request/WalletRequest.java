package com.tullyo.wallet.infrastructure.adapters.inbound.dtos.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletRequest {

  @NotBlank(message = "Título é um campo obrigatório")
  private String title;

  @NotBlank(message = "Nome é um campo obrigatório")
  private String name;

  @NotBlank(message = "Seguimento é um campo obrigatório")
  private String segment;

  @NotBlank(message = "Tipo é um campo obrigatório")
  private String type;

}
