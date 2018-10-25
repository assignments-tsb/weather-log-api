package ph.homecredit.weatherlog.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * the weather log information fetched from https://openweathermap.org/,
 * we re only fetching the data that we need
 */
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class WeatherLog {

    String location;
    String actualWeather;
    String temperature;
}
