package com.weather.service;

import com.weather.page.vo.CountryCityPageVO;

public interface CountryService {
  
  public CountryCityPageVO getCityNames(String queryText);

}
