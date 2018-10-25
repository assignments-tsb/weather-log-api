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

@RestController
@RequestMapping(value = "/weather-log")
@AllArgsConstructor
@Slf4j
public class WeatherLogAPI {

    private final WeatherLogService service;

    /**
     * curl -X GET http://localhost:8081/weather-log?locations=London,Prague,San+Francisco
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
        return service.findByLocations(locations);
    }
}
