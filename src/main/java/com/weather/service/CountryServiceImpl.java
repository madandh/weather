package com.weather.service;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.AppProperties;
import com.weather.page.vo.CountryCityPageVO;
import com.weather.vo.PredictionsVO;

@Service
public class CountryServiceImpl implements CountryService {

  private static Logger logger = LoggerFactory.getLogger(
      CountryServiceImpl.class);

  @Inject
  AppProperties appProperties;

  @Inject
  WeatherHttpService weatherHttpService;

  ObjectMapper mapper = new ObjectMapper();

  @Override
  public CountryCityPageVO getCityNames(String queryText) {
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    CountryCityPageVO count = new CountryCityPageVO();

    String countrie = weatherHttpService.sendGet(getGoogleAPIUrl(queryText));
    
    try {
      count = mapper.readValue(countrie, CountryCityPageVO.class);
      removeStateName(count);
    } catch (IOException e) {
      logger.error("Error in parsing JSON to Object");
    }
    return count;

  }

  private void removeStateName(CountryCityPageVO countryVO) {

    for (PredictionsVO desc : countryVO.getPredictions()) {
      String[] cityStateCountryArray = desc.getDescription().split(",");
      if (cityStateCountryArray.length == 3) {
        desc.setDescription(cityStateCountryArray[0] + " ," + cityStateCountryArray[2]);
      }
    }

  }

  private String getGoogleAPIUrl(String queryText) {
    return appProperties.getGoogleApiUrl() + "input=" + queryText + "&types=(cities)&key="
        + appProperties.getGoogleApiKey();
  }

}
