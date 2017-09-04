package com.weather.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherVO {
  
  
  @JsonProperty("dt")
  Long timestamp;
  
  @JsonProperty("weather")
  List<Weather> weather;
  
  @JsonProperty("main")
  TempratureVO tempratureVO;
  
  @JsonProperty("wind")
  WindVO wind;

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public List<Weather> getWeather() {
    return weather;
  }

  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }

  public TempratureVO getTempratureVO() {
    return tempratureVO;
  }

  public void setTempratureVO(TempratureVO tempratureVO) {
    this.tempratureVO = tempratureVO;
  }

  public WindVO getWind() {
    return wind;
  }

  public void setWind(WindVO wind) {
    this.wind = wind;
  }
  
  
  
  

}
