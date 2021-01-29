package fib.controller;

import fib.service.FibService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FibController {

    private final FibService fibService;

    @GetMapping("/fib/{number}")
    public long calculate(@PathVariable int number) {
        log.info("Received fib request for :: " + number);
        long result = fibService.calculateFib(number);
        log.info("Result :: " + result);
        return result;
    }
}
