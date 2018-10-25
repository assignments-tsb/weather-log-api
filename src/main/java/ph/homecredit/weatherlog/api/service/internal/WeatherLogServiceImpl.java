package ph.homecredit.weatherlog.api.service.internal;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ph.homecredit.weatherlog.api.client.openweathermap.OpenWeatherMapClient;
import ph.homecredit.weatherlog.api.model.WeatherLog;
import ph.homecredit.weatherlog.api.service.WeatherLogService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class WeatherLogServiceImpl implements WeatherLogService {

    OpenWeatherMapClient openWeatherMap;

    @Override
    public List<WeatherLog> findByLocations(List<String> locations) {
        log.debug("finding weather logs for: {}", locations);
        return locations.stream()
                .map(openWeatherMap::findByLocation)
                .collect(Collectors.toList());
    }
}
