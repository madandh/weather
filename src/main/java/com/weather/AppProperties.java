package com.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppProperties {
  
  @Value("${weather.api.url}")
  private String weatherApiUrl;
  
  @Value("${weather.api.key}")
  private String weatherApiKey;
  
  @Value("${google.api.url}")
  private String googleApiUrl;
  
  @Value("${google.api.key}")
  private String googleApiKey;

  public String getWeatherApiUrl() {
    return weatherApiUrl;
  }

  public String getWeatherApiKey() {
    return weatherApiKey;
  }


  public String getGoogleApiUrl() {
    return googleApiUrl;
  }

  public void setGoogleApiUrl(String googleApiUrl) {
    this.googleApiUrl = googleApiUrl;
  }

  public void setWeatherApiUrl(String weatherApiUrl) {
    this.weatherApiUrl = weatherApiUrl;
  }

  public void setWeatherApiKey(String weatherApiKey) {
    this.weatherApiKey = weatherApiKey;
  }

  public String getGoogleApiKey() {
    return googleApiKey;
  }

  public void setGoogleApiKey(String googleApiKey) {
    this.googleApiKey = googleApiKey;
  }

}
