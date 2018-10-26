package ph.homecredit.weatherlog.api.client.memstore.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ph.homecredit.weatherlog.api.client.memstore.MemstoreClient;
import ph.homecredit.weatherlog.api.model.WeatherLog;

import java.util.List;

/**
 * a dummy implementation that uses a local JVM heap for object storage.
 * ideally we probably should use something like redis or memcached.
 */
@Component
@Slf4j
public class LocalMemstoreClient implements MemstoreClient {

    @Override
    public void enqueue(WeatherLog weatherLog) {
        log.debug("Storing: {}", weatherLog);

    }

    @Override
    public List<WeatherLog> findMostRecent() {
        return null;
    }
}
