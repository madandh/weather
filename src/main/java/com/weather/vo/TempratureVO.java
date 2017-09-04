package com.weather.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TempratureVO {

  String temp;
  
  String pressure;
  
  String humidity;
  
  String temp_min;
  
  String temp_max;

  public String getTemp() {
    return temp;
  }

  public void setTemp(String temp) {
    this.temp = temp;
  }

  public String getPressure() {
    return pressure;
  }

  public void setPressure(String pressure) {
    this.pressure = pressure;
  }

  public String getHumidity() {
    return humidity;
  }

  public void setHumidity(String humidity) {
    this.humidity = humidity;
  }

  public String getTemp_min() {
    return temp_min;
  }

  public void setTemp_min(String temp_min) {
    this.temp_min = temp_min;
  }

  public String getTemp_max() {
    return temp_max;
  }

  public void setTemp_max(String temp_max) {
    this.temp_max = temp_max;
  }

}
