package com.weather.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WeatherHttpServiceImpl implements WeatherHttpService {
  
  private static Logger logger = LoggerFactory.getLogger(
      WeatherHttpServiceImpl.class);


  @Override
  public String sendGet(String uri) {
    String output ="";
    StringBuffer response = new StringBuffer();
    try {
      URL url = new URL(uri);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");

      if (conn.getResponseCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
            + conn.getResponseCode());
      }

      BufferedReader br = new BufferedReader(new InputStreamReader(
        (conn.getInputStream())));

      
      logger.info("Output from Server .... \n");
      while ((output = br.readLine()) != null) {
        response.append(output);
      }

      conn.disconnect();
    } catch (Exception e) {
      logger.error("Please try again, weather service is down for a moment due to {}",e.getMessage());
    }
    
    logger.info("Response data {}",response.toString());
    return response.toString();

  }

}
