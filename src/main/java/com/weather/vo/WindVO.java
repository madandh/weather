package com.weather.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WindVO {
  
  Integer speed;
  
  Integer deg;

  public Integer getSpeed() {
    return speed;
  }

  public void setSpeed(Integer speed) {
    this.speed = speed;
  }

  public Integer getDeg() {
    return deg;
  }

  public void setDeg(Integer deg) {
    this.deg = deg;
  }

}
