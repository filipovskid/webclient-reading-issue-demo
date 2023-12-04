package com.filipovski.dataclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.logging.Logger;

import reactor.core.publisher.Flux;

@RestController
public class DataClientController {

  Logger log = Logger.getLogger(DataClientController.class.getName());

  private final WebClient webClient;

  public DataClientController(WebClient webClient) {
    this.webClient = webClient;
  }

  /**
   * Non-working data loading.
   */
  @GetMapping("/get-data-objects")
  public List<Object> getDataObjects() {
    log.info(Thread.currentThread().getName());
    return webClient.get()
        .uri(uriBuilder -> uriBuilder.path("/data").build())
        .retrieve()
        .bodyToFlux(Object.class)
        .collectList()
        .block();
  }

  /**
   * Non-working data loading.
   */
  @GetMapping("/get-data-objects-flux")
  public Flux<Object> getDataObjectsFlux() {
    log.info(Thread.currentThread().getName());
    return webClient.get()
        .uri(uriBuilder -> uriBuilder.path("/data").build())
        .retrieve()
        .bodyToFlux(Object.class);
  }

  /**
   * Working data loading. Make sure that this endpoint does not get invoked first.
   */
  @GetMapping("/get-data-object")
  public Object getDataObject() {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder.path("/data").build())
        .retrieve()
        .bodyToMono(Object.class)
        .block();
  }
}
