package org.ajou.realcoding.weathercrawler.weathercrawler.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ajou.realcoding.weathercrawler.weathercrawler.api.OpenWeatherMapApiClient;
import org.ajou.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.ajou.realcoding.weathercrawler.weathercrawler.repository.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class WeatherService {
    // 자동 객체화
    List<String> cities = null;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    OpenWeatherMapApiClient openWeatherMapApiClient;

    @PostConstruct
    public void loadAvailableCityNamesFromFile() throws IOException {
        File file = new File("availableCityNames.json");
        cities = objectMapper.readValue(file, new TypeReference<List<String>>(){});
    }

    public List<String> getAvailableCityNamesFromFile() {
        return cities;
    }

    public CurrentWeather getCurrentWeatherByCityName(String cityName)
    {
        return openWeatherMapApiClient.requestCurrentWeather(cityName);
    }

    LinkedList<String> citiesQueue = new LinkedList<>();
    @Autowired
    CurrentWeatherRepository currentWeatherRepository;

    @Scheduled(fixedDelay = 2000L)
    public void getCurrentWeatherPeriodically() {
        if(citiesQueue.isEmpty()) {
            citiesQueue.addAll(getAvailableCityNamesFromFile());
        }
        String targetCity = citiesQueue.pop();
        citiesQueue.addLast(targetCity);

        CurrentWeather currentWeather = openWeatherMapApiClient.requestCurrentWeather(targetCity);
        currentWeatherRepository.insertCurrentWeather(currentWeather);
    }
}
