package com.ktung.happygiphy.model.giphy;

import com.fasterxml.jackson.annotation.JsonAlias;

public class GifModel {
  public String id;
  public String title;
  @JsonAlias(value = "embed_url")
  public String embedUrl;
}
