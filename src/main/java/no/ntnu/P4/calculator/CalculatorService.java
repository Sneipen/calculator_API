package no.ntnu.P4.calculator;

import org.springframework.stereotype.Service;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/*
   Class to represent a calculator
 */

@Service
public class CalculatorService {


    private final String ERROR_MSG = "Invalid expression";
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

    public Calculation getCalculation(Long id, String expression) {
        Calculation calculation = new Calculation(id, expression);
        return calculate(calculation);
    }

    private Calculation calculate(Calculation calculation) {
        Object o = null;
        String answer;
        boolean goodInput = true;
        try {
            calculation.setExpression(URLEncoder.encode(calculation.getExpression(), StandardCharsets.UTF_8.toString()));
        }catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }


        try {
            o = engine.eval(calculation.getExpression());
        }catch (ScriptException e) {
            System.out.println(e.getMessage());
            goodInput = false;
        }
        if(goodInput) {
            answer = o.toString();
            calculation.setAnswer(answer);
            System.out.println(answer);
        } else {
            calculation.setAnswer(ERROR_MSG);
        }
        return calculation;
    }



}
