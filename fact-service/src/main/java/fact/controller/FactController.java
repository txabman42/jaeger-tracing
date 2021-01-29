package fact.controller;

import fact.service.FactService;
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
public class FactController {

    private final FactService factService;

    @GetMapping("/fact/{number}")
    public Long calculate(@PathVariable("number") int number) {
        log.info("Received fact request for :: " + number);
        long result = factService.calculateFactorial(number);
        log.info("Result :: " + result);
        return result;
    }

    @GetMapping("/health")
    public void health() {
        log.info("Fact is up & healthy!");
    }

}
