package ph.homecredit.weatherlog.api.service;

import ph.homecredit.weatherlog.api.model.WeatherLog;

import java.util.List;

public interface WeatherLogService {

    List<WeatherLog> findByLocations(List<String> locations);

    void storeRecentWeatherLogs();
}
