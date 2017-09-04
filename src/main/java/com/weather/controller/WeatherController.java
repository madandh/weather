package com.weather.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.page.vo.WeatherPageVO;
import com.weather.service.WeatherService;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200") 
public class WeatherController {
  
  @Inject
  WeatherService weatherService;
  
  ObjectMapper mapper = new ObjectMapper();
  
  @RequestMapping(value = "/getWeatherByCity",method = RequestMethod.GET)
  private String getCountryList(@RequestParam("cityName")String cityName){
    WeatherPageVO weather = weatherService.getWeatherByCity(cityName);
    try {
      return mapper.writeValueAsString(weather);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    
    return "";
  }

}
