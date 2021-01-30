package fib.controller;

import fib.service.FibService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequestMapping("/api/fib")
@RequiredArgsConstructor
public class FibController {

    private final FibService fibService;

    @GetMapping("/{number}")
    public long calculate(@PathVariable int number) {
        return generateCalculation(number);
    }

    @GetMapping("/retry/{number}")
    public long calculateRetry(@PathVariable int number) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 4);

        if(randomNumber < 2)
            return generateCalculation(number);
        else
            throw new RuntimeException();
    }

    private long generateCalculation(int number) {
        log.info("Received fib request for :: " + number);
        long result = fibService.calculateFib(number);
        log.info("Result :: " + result);
        return result;
    }
}
