package fact.controller;

import fact.service.FactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequestMapping("/api/fact")
@RequiredArgsConstructor
public class FactController {

    private final FactService factService;

    @GetMapping("/{number}")
    public Long calculate(@PathVariable("number") int number) {
        return generateCalculation(number);
    }

    @GetMapping("/retry/{number}")
    public Long calculateRetry(@PathVariable("number") int number) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 4);

        if(randomNumber < 2)
            return generateCalculation(number);
        else
            throw new RuntimeException();
    }

    private long generateCalculation(int number) {
        log.info("Received fact request for :: " + number);
        long result = factService.calculateFactorial(number);
        log.info("Result :: " + result);
        return result;
    }
}