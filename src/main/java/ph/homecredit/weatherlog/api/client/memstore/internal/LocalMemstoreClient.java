package ph.homecredit.weatherlog.api.client.memstore.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ph.homecredit.weatherlog.api.client.memstore.MemstoreClient;
import ph.homecredit.weatherlog.api.model.WeatherLog;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * a dummy implementation that uses a local JVM heap for object storage.
 * ideally we probably should use something like redis or memcached.
 */
@Component
@Slf4j
public class LocalMemstoreClient implements MemstoreClient {

    private static final int MAX_SIZE = 5;
    private List<WeatherLog> buffer = new LinkedList<>();

    @Override
    public void enqueue(WeatherLog weatherLog) {
        log.debug("Storing: {}", weatherLog);

        buffer.add(weatherLog);

        if (buffer.size() > MAX_SIZE) {
            buffer = buffer.subList(buffer.size()-MAX_SIZE, buffer.size());
        }
    }

    @Override
    public List<WeatherLog> findMostRecent() {
        return Collections.unmodifiableList(buffer);
    }
}
