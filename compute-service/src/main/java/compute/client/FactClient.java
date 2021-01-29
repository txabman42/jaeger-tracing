package compute.client;

import compute.configuration.ClientConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

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
        URI uri = generateUri(fact, number);
        return restTemplate.getForObject(uri, Long.class);
    }

}
