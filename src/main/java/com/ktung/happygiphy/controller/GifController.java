package com.ktung.happygiphy.controller;

import com.ktung.happygiphy.model.giphy.ResponseModel;
import com.ktung.happygiphy.services.GiphyService;
import com.ktung.happygiphy.services.MSTeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GifController {

  @Autowired
  private GiphyService giphyService;

  @Autowired
  private MSTeamsService msTeamsService;

  @GetMapping("gif")
  public ResponseEntity<String> sendGif() {
    ResponseModel response = giphyService.getRandomGif();
    msTeamsService.sendGif(response.data);
    return new ResponseEntity<>(response.data.id, HttpStatus.OK);
  }
}
