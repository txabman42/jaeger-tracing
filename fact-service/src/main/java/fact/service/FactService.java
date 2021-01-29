package fact.service;

import org.springframework.stereotype.Service;

@Service
public class FactService {

    public Long calculateFactorial(final int number) {
        final long result = getFact(number);
        return result;
    }

    private long getFact(int number) {
        long fact = 1;
        for (int i = 2; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
