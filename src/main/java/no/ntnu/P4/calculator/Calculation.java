package no.ntnu.P4.calculator;

/*
    Class to represent a calculation
 */

public class Calculation {
    private Long id;
    private String expression;
    private String answer;

    public Calculation(long id, String expression) {
        this.id = id;
        this.expression = expression;
    }

    public Long getId() {
        return id;
    }

    public String getExpression() {
        return expression;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setExpression(String newExpression) {
        this.expression = newExpression;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "id=" + id +
                ", expression='" + expression + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
