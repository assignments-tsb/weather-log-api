package ph.homecredit.weatherlog.api;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherLogApiApplication {

	@Data
	@Configuration
	@ConfigurationProperties(prefix = "ph.homecredit.weatherlog.api")
	public static class Config {

		String weatherMapAPIKey;
		String weatherMapAPIURI;
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherLogApiApplication.class, args);
	}
}
