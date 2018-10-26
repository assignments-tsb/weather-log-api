package ph.homecredit.weatherlog.api.client.memstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ph.homecredit.weatherlog.api.client.memstore.internal.LocalMemstoreClient;
import ph.homecredit.weatherlog.api.model.WeatherLog;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemstoreClientTest {

    private MemstoreClient memstore;

    @BeforeEach
    void setUp() {
        memstore = new LocalMemstoreClient();
    }

    @Test
    void shouldStoreFiveMostRecent() {

        List<WeatherLog> weatherLogs = Arrays.asList(
                WeatherLog.builder().responseId("aaaa").build(),
                WeatherLog.builder().responseId("bbbb").build(),
                WeatherLog.builder().responseId("cccc").build(),
                WeatherLog.builder().responseId("dddd").build(),
                WeatherLog.builder().responseId("eeee").build(),
                WeatherLog.builder().responseId("ffff").build()
        );

        weatherLogs.forEach(memstore::enqueue);


        List<WeatherLog> storedWeatherLogs = memstore.findMostRecent();

        assertNotNull(storedWeatherLogs);
        assertEquals(5, storedWeatherLogs.size());

        assertAll("contains the 5 most recent weather logs",
                () -> assertTrue(contains(storedWeatherLogs, "bbbb")),
                () -> assertTrue(contains(storedWeatherLogs, "cccc")),
                () -> assertTrue(contains(storedWeatherLogs, "dddd")),
                () -> assertTrue(contains(storedWeatherLogs, "eeee")),
                () -> assertTrue(contains(storedWeatherLogs, "ffff"))
        );

        assertTrue(!contains(storedWeatherLogs, "aaaa"));
    }

    private boolean contains(List<WeatherLog> results, String responseId) {
        return results.stream().anyMatch((weatherLog) -> weatherLog.getResponseId().equals(responseId));
    }
}
