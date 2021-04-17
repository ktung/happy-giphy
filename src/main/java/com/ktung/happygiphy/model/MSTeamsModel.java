package com.ktung.happygiphy.model;

public class MSTeamsModel {

  private final String textFormat = "markdown";

  private String text;

  public String getTextFormat() {
    return textFormat;
  }

  public String getText() {
    return text;
  }

  public static class Builder {
    private final MSTeamsModel model = new MSTeamsModel();

    public Builder withText(String text) {
      model.text = text;
      return this;
    }

    public MSTeamsModel build() {
      return model;
    }
  }
}
