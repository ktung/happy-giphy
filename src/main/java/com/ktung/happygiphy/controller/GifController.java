package com.ktung.happygiphy.controller;

import com.ktung.happygiphy.model.giphy.ResponseModel;
import com.ktung.happygiphy.services.GiphyService;
import com.ktung.happygiphy.services.MSTeamsService;
import com.ktung.happygiphy.utils.GiphyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GifController {

  private final Logger LOG = LoggerFactory.getLogger(GifController.class);

  @Autowired
  private GiphyService giphyService;

  @Autowired
  private MSTeamsService msTeamsService;

  @GetMapping("gif")
  public ResponseEntity<String> sendGif() {
    ResponseModel response = giphyService.getRandomGif();
    String gifImageUrl = GiphyUtils.toImageUrl(response.data.id);
    LOG.info("GifURL {}", gifImageUrl);
    msTeamsService.sendGif(response.data.title, gifImageUrl);
    return new ResponseEntity<>(gifImageUrl, HttpStatus.OK);
  }
}
