package operations;

import exceptions.ExpressionException;
import exceptions.IncorrectConstException;
import exceptions.OverflowException;

public class DoubleOperations implements Operation<Double> {
    @Override
    public Double parseConst(String number) throws IncorrectConstException {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException a) {
            throw new IncorrectConstException();
        }
    }

    @Override
    public Double add(Double x, Double y) throws OverflowException {
        return x + y;
    }

    @Override
    public Double sub(Double x, Double y) throws OverflowException {
        return x - y;
    }

    @Override
    public Double mul(Double x, Double y) throws OverflowException {
        return x * y;
    }

    @Override
    public Double div(Double x, Double y) throws ExpressionException {
        return x / y;
    }

    @Override
    public Double not(Double x) throws OverflowException {
        return -x;
    }

    @Override
    public Double abs(Double x) throws OverflowException {
        return Math.abs(x);
    }

    @Override
    public Double low(Double x) {
        return null;
    }

    @Override
    public Double high(Double x) {
        return null;
    }

    @Override
    public Double mod(Double x, Double y) {
        return x % y;
    }

    @Override
    public Double square(Double x) throws ExpressionException {
        return x * x;
    }
}
