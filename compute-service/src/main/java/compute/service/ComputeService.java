package compute.service;

import compute.client.FactClient;
import compute.client.FibClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ComputeService {

    private final FibClient fibClient;

    private final FactClient factClient;

    public Long findFib(int number) {
        return fibClient.calculate(number);
    }

    public Long findFact(int number) {
        return factClient.calculate(number);
    }

    public Long sumFact(int number) {
        return IntStream.rangeClosed(1, number)
                .parallel()
                .mapToLong(factClient::calculate)
                .sum();
    }
}
