package compute.client;

import compute.configuration.ClientConfiguration;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class FibClient extends AlgorithmClient {

    private final ClientConfiguration.Fib fib;

    private final RestTemplate restTemplate;

    public FibClient(ClientConfiguration clientConfiguration, RestTemplate restTemplate) {
        this.fib = clientConfiguration.getFib();
        this.restTemplate = restTemplate;
    }

    @Override
    public long calculate(int number) {
        URI uri = generateUri(fib, fib.getPath(), number);
        return restTemplate.getForObject(uri, Long.class);
    }

    @Retry(name = "fibRetry", fallbackMethod = "dummyFallback")
    @Override
    public long calculateRetry(int number) {
        URI uri = generateUri(fib, fib.getPathRetry(), number);
        return restTemplate.getForObject(uri, Long.class);
    }

}
