package com.weather.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.page.vo.CountryCityPageVO;
import com.weather.service.CountryService;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200") 
public class CountryController {
  
  @Inject 
  CountryService countryService;
  
  ObjectMapper mapper = new ObjectMapper();
  
  @RequestMapping(value = "/getCityList",method = RequestMethod.GET)
  private String getCountryList(@RequestParam("cityQueryText")String cityQuery){
    CountryCityPageVO countries = countryService.getCityNames(cityQuery);
    try {
      return mapper.writeValueAsString(countries.getPredictions());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    
    return "";
  }
  
  

}
