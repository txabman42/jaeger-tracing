package compute.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("compute")
public class ClientConfiguration {

    private final Fact fact = new Fact();

    private final Fib fib = new Fib();

    @Getter
    @Setter
    public static abstract class Algorithm {
        private String protocol;
        private String host;
        private Integer port;
        private String path;
        private String pathRetry;
    }

    @Getter
    @Setter
    public static class Fact extends Algorithm {
    }

    @Getter
    @Setter
    public static class Fib extends Algorithm {
    }
}
