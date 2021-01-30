package compute.controller;

import compute.service.ComputeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compute")
@RequiredArgsConstructor
public class ComputeController {

    private final ComputeService computeService;

    @GetMapping("/fib/{number}")
    public Long fib(@PathVariable int number) {
        return this.computeService.findFib(number);
    }

    @GetMapping("/fact/{number}")
    public Long fact(@PathVariable int number) {
        return this.computeService.findFact(number);
    }

    @GetMapping("/sum-fact/{number}")
    public Long sumFact(@PathVariable int number) {
        return this.computeService.sumFact(number);
    }

    @GetMapping("/fib/retry/{number}")
    public Long fibRetry(@PathVariable int number) {
        return this.computeService.findFibRetry(number);
    }

    @GetMapping("/fact/retry/{number}")
    public Long factRetry(@PathVariable int number) {
        return this.computeService.findFactRetry(number);
    }
}
