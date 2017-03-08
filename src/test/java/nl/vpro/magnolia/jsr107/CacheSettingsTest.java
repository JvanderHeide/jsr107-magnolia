package nl.vpro.magnolia.jsr107;

import java.time.Duration;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author Michiel Meeuwissen
 * @since 1.11
 */
public class CacheSettingsTest {


    @Test
    public void testBasics() {

        assertThat(CacheSettings.builder()
            .build()
            .getMaxElementsInMemory())
            .isEqualTo(500);

        assertThat(CacheSettings.builder()
            .timeToIdle(Duration.ofSeconds(60))
            .build()
            .getTimeToIdleSeconds())
            .isEqualTo(60);

        assertThat(CacheSettings.builder()
            .copyOnWrite(true)
            .build()
            .isCopyOnWrite())
            .isTrue();

        assertThat(CacheSettings.builder()
            .eternal(true)
            .build()
            .isEternal())
            .isTrue();
    }

    @Test
    public void settingEternalResetsTTLDefaults() {
        assertThat(CacheSettings.builder()
            .eternal(true)
            .build()
            .getTimeToIdleSeconds())
            .isNull();


    }

}
