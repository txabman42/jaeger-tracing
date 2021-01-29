package compute.client;

import compute.configuration.ClientConfiguration;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public abstract class AlgorithmClient {

    public abstract long calculate(int number);

    protected URI generateUri(ClientConfiguration.Algorithm algorithm, int number) {
        try {
            String completePath = algorithm.getPath() + "/" + number;
            return new URI(algorithm.getProtocol(), null, algorithm.getHost(), algorithm.getPort(),
                    completePath, null, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
