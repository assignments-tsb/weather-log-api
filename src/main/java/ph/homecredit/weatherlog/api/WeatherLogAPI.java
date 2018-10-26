package ph.homecredit.weatherlog.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ph.homecredit.weatherlog.api.model.WeatherLog;
import ph.homecredit.weatherlog.api.service.WeatherLogService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = "/weather-log")
@AllArgsConstructor
@Slf4j
public class WeatherLogAPI {

    private final WeatherLogService service;

    /**
     * API-1:
     *
     * curl -X GET http://localhost:8081/weather-log?locations=London,Prague,San+Francisco
     *
     * or
     *
     * curl -X GET https://localhost:8081/weather-log
     *
     * - list of weather from London, Prague, and San Francisco
     * - include location, actual weather, and temperature
     * - json format
     *
     * @param locations the locations that you want to fetch the weather
     * @return the list of weather logs from the specified locations
     */
    @RequestMapping(method = GET)
    public List<WeatherLog> findByLocations(@RequestParam(value = "locations", defaultValue = "London,Prague,San+Francisco") List<String> locations) {
        log.debug("api1: {}", locations);
        return service.findByLocations(locations);
    }

    /**
     * API-2:
     *
     * curl -X PUT http://localhost:8081/weather-log
     *
     * store the most recent weather logs
     * - store 5 most recent unique results from the API-1 invokations
     */
    @RequestMapping(method = PUT)
    public void storeRecentWeatherLogs() {
        log.debug("api2");

        service.storeRecentWeatherLogs();
    }
}
