package org.ajou.realcoding.weathercrawler.weathercrawler.controller;

import org.ajou.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.ajou.realcoding.weathercrawler.weathercrawler.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/weather-crawler/available-cities")
    public List<String> getAvailableCities() throws IOException {
        if(weatherService.getAvailableCityNamesFromFile() == null) weatherService.loadAvailableCityNamesFromFile();
        return weatherService.getAvailableCityNamesFromFile();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/weather-crawler/current-weathers/by-city-name")
    public CurrentWeather getCurrentWeather(@RequestParam String cityName) {
        return weatherService.getCurrentWeatherByCityName(cityName);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/weather-crawler/current-weathers/by-city-name/{cityName}")
    public CurrentWeather getCurrentWeather2(@PathVariable String cityName) {
        return weatherService.getCurrentWeatherByCityName(cityName);
    }
}
