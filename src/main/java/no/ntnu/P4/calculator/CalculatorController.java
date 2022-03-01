package no.ntnu.P4.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

/*
    Class to represent a user endpoint. Handles requests
 */

@RestController
@RequestMapping("api/calculation")
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public Calculation getCalculation(@RequestParam(value = "expression", defaultValue = "Invalid expression") String expression) {
        return calculatorService.getCalculation(counter.incrementAndGet(), expression);
    }

}
