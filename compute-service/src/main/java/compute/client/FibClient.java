package compute.client;

import compute.configuration.ClientConfiguration;
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
        URI uri = generateUri(fib, number);
        return restTemplate.getForObject(uri, Long.class);
    }

}
