package com.ktung.happygiphy.services;

import com.ktung.happygiphy.model.giphy.ResponseModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GiphyService {

  @Value("${giphy.url}")
  private String apiUrl;

  @Value("${giphy.apiKey}")
  private String apiKey;

  private final RestTemplate restTemplate;

  public GiphyService() {
    this.restTemplate = new RestTemplate();
    this.restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
  }

  public ResponseModel getRandomGif() {
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl + "/random")
        .queryParam("api_key", apiKey)
        .queryParam("tag", "chaton");

    return this.restTemplate.getForEntity(uriBuilder.toUriString(), ResponseModel.class).getBody();
  }
}
