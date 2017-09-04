package com.weather.page.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.vo.PredictionsVO;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CountryCityPageVO {
  
  @JsonProperty("predictions")
  List<PredictionsVO> predictions;

  public List<PredictionsVO> getPredictions() {
    return predictions;
  }

  public void setPredictions(List<PredictionsVO> predictions) {
    this.predictions = predictions;
  }
  

}
