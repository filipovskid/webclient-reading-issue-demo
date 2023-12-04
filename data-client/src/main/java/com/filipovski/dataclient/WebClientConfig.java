package com.filipovski.dataclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.codec.http.HttpObjectAggregator;
import reactor.netty.NettyPipeline;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {

  private static final int MAX_RESPONSE_CONTENT_LENGTH = 1048576;
  private static final String BASE_URL = "http://localhost:8080";

  @Bean
  public WebClient webClient() {
    HttpClient httpClient = createHttpClient();
    return createWebClientWithHttpClient(WebClient.builder(), httpClient);
  }

  private HttpClient createHttpClient() {
    return HttpClient.create()
        .doOnChannelInit((observer, channel, remoteAddress) -> channel.pipeline()
            .addAfter(NettyPipeline.HttpCodec, NettyPipeline.HttpAggregator,
                new HttpObjectAggregator(MAX_RESPONSE_CONTENT_LENGTH)));

  }

  private WebClient createWebClientWithHttpClient(WebClient.Builder webClientBuilder, HttpClient reactiveHttpClient) {
    ReactorClientHttpConnector connector = new ReactorClientHttpConnector(reactiveHttpClient);
    return webClientBuilder.baseUrl(BASE_URL)
        .clientConnector(connector)
        .build();
  }
}
