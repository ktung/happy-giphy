package com.ktung.happygiphy.utils;

public class GiphyUtils {
  private GiphyUtils() {
  }

  public static String toImageUrl(String id) {
    return String.format("https://media.giphy.com/media/%s/giphy.gif", id);
  }
}
