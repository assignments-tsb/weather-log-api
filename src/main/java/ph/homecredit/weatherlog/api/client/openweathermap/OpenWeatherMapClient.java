package ph.homecredit.weatherlog.api.client.openweathermap;

import ph.homecredit.weatherlog.api.model.WeatherLog;

public interface OpenWeatherMapClient {

    WeatherLog findByLocation(String location);

}
