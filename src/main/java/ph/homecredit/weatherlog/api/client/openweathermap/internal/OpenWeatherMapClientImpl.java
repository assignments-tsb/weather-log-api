package ph.homecredit.weatherlog.api.client.openweathermap.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ph.homecredit.weatherlog.api.WeatherLogApiApplication;
import ph.homecredit.weatherlog.api.client.openweathermap.OpenWeatherMapClient;
import ph.homecredit.weatherlog.api.model.WeatherLog;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class OpenWeatherMapClientImpl implements OpenWeatherMapClient {

    WeatherLogApiApplication.Config config;
    RestTemplate rest;

    @Override
    public WeatherLog findByLocation(String location) {
        log.debug("Searching for weather: {}", location);

        //TODO: error handler for when things go wrong
        return rest.getForEntity(UriComponentsBuilder
                .fromHttpUrl(config.getWeatherMapAPIURI())
                .path("/weather")
                .queryParam("appid", config.getWeatherMapAPIKey())
                .queryParam("q", location).build().toUriString(), WeatherInternal.class)
                .getBody() //this can be null when something goes wrong with the get request
                .toWeatherLog();
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class WeatherInternal {

        String name;
        List<Weather> weather;
        Main main;

        @Data
        static class Weather {
            String description;
        }

        @Data
        static class Main {
            String temp;
        }

        WeatherLog toWeatherLog() {
            return WeatherLog.builder()
                    .responseId(UUID.randomUUID().toString())
                    .actualWeather(weather.get(0).description)
                    .location(name)
                    .temperature(main.temp)
                    .build();
        }

    }
}
