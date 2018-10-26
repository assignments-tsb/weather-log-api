package ph.homecredit.weatherlog.api.client.memstore;

import ph.homecredit.weatherlog.api.model.WeatherLog;

import java.util.List;

/**
 * a distributed buffer storage for the top 5 recently returned weather logs
 */
public interface MemstoreClient {

    /**
     * stores up to 5 unique most recent weather logs
     * @param weatherLog the weather log to store
     */
    void enqueue(WeatherLog weatherLog);

    /**
     * fetches the 5 most recent weather logs
     *
     * @return
     */
    List<WeatherLog> findMostRecent();
}
