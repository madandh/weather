package com.weather.service;

import com.weather.page.vo.WeatherPageVO;

public interface WeatherService {
  
  
  public WeatherPageVO getWeatherByCity(String cityName); 

}
