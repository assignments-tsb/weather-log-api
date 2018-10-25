package ph.homecredit.weatherlog.api.client.openweathermap.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ph.homecredit.weatherlog.api.client.openweathermap.OpenWeatherMapClient;
import ph.homecredit.weatherlog.api.model.WeatherLog;

@Slf4j
@Component
public class OpenWeatherMapClientImpl implements OpenWeatherMapClient {

    @Override
    public WeatherLog findByLocation(String location) {
        log.debug("Searching for weather: {}", location);

        return WeatherLog.builder()
                .location("Manila")
                .actualWeather("really cloudy")
                .temperature("212.22")
                .build();
    }
}
