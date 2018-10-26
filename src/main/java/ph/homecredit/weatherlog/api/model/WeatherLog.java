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

    //a globally unique id, generated when the response is created
    String responseId;

    String location;
    String actualWeather;
    String temperature;
}
