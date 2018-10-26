package ph.homecredit.weatherlog.api.service.internal;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import ph.homecredit.weatherlog.api.client.memstore.MemstoreClient;
import ph.homecredit.weatherlog.api.model.WeatherLog;

import java.util.List;

@Slf4j
@Aspect
@Service
@AllArgsConstructor
public class WeatherLogServiceAspect {

    MemstoreClient memstore;

    /**
     * we listen to returned weather logs without messing around the previous code
     * @param weatherLogs
     */
    @AfterReturning(pointcut = "execution(* ph.homecredit.weatherlog.api.service.WeatherLogService.findByLocations(..))", returning = "weatherLogs")
    public void afterReturningWeatherLogs(List<WeatherLog> weatherLogs) {
        log.info("Returned: {}", weatherLogs);

        weatherLogs.forEach(memstore::enqueue);
    }
}
