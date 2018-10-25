package ph.homecredit.weatherlog.api.service.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ph.homecredit.weatherlog.api.model.WeatherLog;
import ph.homecredit.weatherlog.api.service.WeatherLogService;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class WeatherLogServiceImpl implements WeatherLogService {

    @Override
    public List<WeatherLog> findByLocations(List<String> locations) {
        log.debug("finding weather logs for: {}", locations);
        return Collections.singletonList(WeatherLog.builder()
                .actualWeather("very cloudy")
                .location("San Francisco")
                .temperature("212.34")
                .build());
    }
}
