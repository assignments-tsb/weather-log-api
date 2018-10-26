package ph.homecredit.weatherlog.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * the weather log information fetched from https://openweathermap.org/,
 * we re only fetching the data that we need
 */
@Data
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor //to satisfy JPA
@Table(name = "\"WeatherLog\"") //specs
public class WeatherLog {

    @Id
    @GeneratedValue(generator = "weather_log_seq", strategy = GenerationType.SEQUENCE)
    @JsonIgnore //not required for rest response
    Long id;

    @CreationTimestamp
    @Column(name = "\"dtimeInserted\"")
    @JsonIgnore
    Date dateTimeInserted;

    //a globally unique id, generated when the response is created
    @JsonIgnore
    String responseId;

    String location;

    @Column(name = "\"actualWeather\"") //specs
    String actualWeather;

    String temperature;
}
