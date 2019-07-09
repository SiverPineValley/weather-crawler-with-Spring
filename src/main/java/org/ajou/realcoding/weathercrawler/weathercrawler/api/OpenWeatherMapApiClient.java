package org.ajou.realcoding.weathercrawler.weathercrawler.api;

import org.ajou.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {
    private final String key = "0d16613d56adecf87c657ce67fe5d1b4";
    private final String openWeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={appid}";

    @Autowired
    RestTemplate restTemplate;

    public CurrentWeather requestCurrentWeather(String cityName) {
        // URL, Method, requestEntity, Response, Variable Parameters
        return restTemplate.exchange(openWeatherUrl, HttpMethod.GET, null, CurrentWeather.class, cityName, key).getBody();
    }
}
