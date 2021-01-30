package compute.client;

import compute.configuration.ClientConfiguration;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Retry(name = "factRetry")
@Component
public class FactClient extends AlgorithmClient {

    private final ClientConfiguration.Fact fact;

    private final RestTemplate restTemplate;

    public FactClient(ClientConfiguration clientConfiguration, RestTemplate restTemplate) {
        this.fact = clientConfiguration.getFact();
        this.restTemplate = restTemplate;
    }

    @Override
    public long calculate(int number) {
        URI uri = generateUri(fact, fact.getPath(), number);
        return restTemplate.getForObject(uri, Long.class);
    }

    @Override
    @Retry(name = "factRetry", fallbackMethod = "dummyFallback")
    public long calculateRetry(int number) {
        URI uri = generateUri(fact, fact.getPathRetry(), number);
        return restTemplate.getForObject(uri, Long.class);
    }

}
