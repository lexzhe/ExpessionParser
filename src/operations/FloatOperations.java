package operations;

import exceptions.ExpressionException;
import exceptions.IncorrectConstException;
import exceptions.OverflowException;

public class FloatOperations implements Operation<Float>{
    @Override
    public Float parseConst(String number) throws IncorrectConstException {
        try {
            return Float.parseFloat(number);
        } catch (NumberFormatException a) {
            throw new IncorrectConstException();
        }
    }

    @Override
    public Float add(Float x, Float y) throws OverflowException {
        return x + y;
    }

    @Override
    public Float sub(Float x, Float y) throws OverflowException {
        return x - y;
    }

    @Override
    public Float mul(Float x, Float y) throws OverflowException {
        return x * y;
    }

    @Override
    public Float div(Float x, Float y) throws ExpressionException {
        return x / y;
    }

    @Override
    public Float not(Float x) throws OverflowException {
        return -x;
    }

    @Override
    public Float abs(Float x) throws OverflowException {
        return Math.abs(x);
    }

    @Override
    public Float low(Float x) {
        return null;
    }

    @Override
    public Float high(Float x) {
        return null;
    }

    @Override
    public Float mod(Float x, Float y) {
        return x % y;
    }

    @Override
    public Float square(Float x) throws ExpressionException {
        return x * x;
    }
}
