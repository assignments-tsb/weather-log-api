package ph.homecredit.weatherlog.api.client.database;

import org.springframework.data.jpa.repository.JpaRepository;
import ph.homecredit.weatherlog.api.model.WeatherLog;

public interface WeatherLogRepository extends JpaRepository<WeatherLog, Long> {
}
