package com.weather.service;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.AppProperties;
import com.weather.page.vo.WeatherPageVO;
import com.weather.vo.Weather;
import com.weather.vo.WeatherVO;

@Service
public class WeatherServiceImpl implements WeatherService {
  
  private static Logger logger = LoggerFactory.getLogger(
      WeatherServiceImpl.class);

  
  @Inject
  AppProperties appProperties;
  
  @Inject
  WeatherHttpService weatherHttpService;
  
  ObjectMapper mapper = new ObjectMapper();

  @Override
  public WeatherPageVO getWeatherByCity(String cityName) {
    WeatherVO weatherVO = new WeatherVO();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    
    String response = weatherHttpService.sendGet(getWeatherURL(cityName));
    
    try {
      weatherVO = mapper.readValue(response, WeatherVO.class);
    } catch (IOException e) {
      logger.error("Error parsing the JSON to Object");;
    }
    return convertWeatherPageVO(weatherVO);
  }
  
  private WeatherPageVO convertWeatherPageVO(WeatherVO weatherVO){
    WeatherPageVO pageVO = new WeatherPageVO();
    if(weatherVO.getTimestamp() != null){
      pageVO.setUpdatedTime(new Date(Long.valueOf(weatherVO.getTimestamp())*1000).toString());
    }
    if(weatherVO.getTempratureVO().getTemp() != null){
      pageVO.setTemprature(weatherVO.getTempratureVO().getTemp());
    }
    
    if(weatherVO.getWeather() != null){
      Weather weather = weatherVO.getWeather().get(0);
      pageVO.setWeather(weather.getDescription());
    }
    
    if(weatherVO.getWind() != null){
      pageVO.setWind(weatherVO.getWind().getSpeed().toString());
    }
    
    return pageVO;
  }
  
  private String getWeatherURL(String cityName){
    return appProperties.getWeatherApiUrl()+cityName+appProperties.getWeatherApiKey()+"&units=metric";
    
  }

}
