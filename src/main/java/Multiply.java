import java.math.BigDecimal;

/**
 * Created by Daniel Solo on 26.07.2016.
 */
public class Multiply implements Operation {
    @Override
    public BigDecimal count(BigDecimal num1, BigDecimal num2) {
        return num1.multiply(num2);
    }

    @Override
    public char getOperator() {
        return '*';
    }
}
