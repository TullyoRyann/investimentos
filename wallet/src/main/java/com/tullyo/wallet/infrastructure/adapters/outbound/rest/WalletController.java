package com.tullyo.wallet.infrastructure.adapters.outbound.rest;

import com.tullyo.wallet.domain.model.Wallet;
import com.tullyo.wallet.domain.ports.in.services.WalletServicePort;
import com.tullyo.wallet.infrastructure.adapters.inbound.dtos.request.WalletRequest;
import com.tullyo.wallet.infrastructure.adapters.inbound.dtos.response.WalletResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController extends BasicController {

  private final WalletServicePort walletServicePort;
  private final ModelMapper modelMapper;

  @PostMapping
  public ResponseEntity<WalletResponse> save(@RequestBody @Valid WalletRequest walletRequest, UriComponentsBuilder componentsBuilder) {
    Wallet wallet = modelMapper.map(walletRequest, Wallet.class);
    Wallet walletSaved = walletServicePort.save(wallet);
    WalletResponse walletResponse = modelMapper.map(walletSaved, WalletResponse.class);

    return ResponseEntity
        .created(componentsBuilder.path(getURI()).buildAndExpand(walletResponse.getId()).toUri())
        .body(walletResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<WalletResponse> get(@PathVariable("id") String id) {
    return walletServicePort.get(id).stream()
        .map(wallet -> modelMapper.map(wallet, WalletResponse.class))
        .map(walletResponse -> ResponseEntity.ok(walletResponse))
        .findFirst()
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<WalletResponse>> findAll() {
    List<WalletResponse> response = StreamSupport.stream(walletServicePort.listAll().spliterator(), false)
        .collect(Collectors.toList())
        .stream()
        .map(wallet -> modelMapper.map(wallet, WalletResponse.class))
        .collect(Collectors.toList());

    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    if(walletServicePort.existWallet(id)) {
      walletServicePort.delete(id);
      return ResponseEntity.noContent().build();
    }

    return  ResponseEntity.notFound().build();
  }

  @Override
  protected String getURI() {
    return "/wallets/{id}";
  }

}
