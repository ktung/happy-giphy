package com.ktung.happygiphy.services;

import com.ktung.happygiphy.model.MSTeamsModel;
import com.ktung.happygiphy.model.giphy.GifModel;
import com.ktung.happygiphy.utils.GiphyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MSTeamsService {

  @Value("${msteamsHook}")
  private String msTeamsHook;

  private final RestTemplate restTemplate;

  private final Logger LOG = LoggerFactory.getLogger(MSTeamsService.class);

  public MSTeamsService() {
    this.restTemplate = new RestTemplate();
    this.restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
  }

  public void sendGif(GifModel gifModel) {
    String gifImageUrl = GiphyUtils.toImageUrl(gifModel.id);
    LOG.info("GifURL {}", gifImageUrl);
    MSTeamsModel model = new MSTeamsModel.Builder()
        .withText(String.format("*%s*\n\n![%s](%s)", gifModel.embedUrl, gifModel.title, gifImageUrl))
        .build();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<MSTeamsModel> request = new HttpEntity<>(model, headers);
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(msTeamsHook);
    this.restTemplate.postForEntity(uriBuilder.toUriString(), request, String.class);
  }
}
