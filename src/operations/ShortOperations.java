package operations;

import exceptions.ExpressionException;
import exceptions.IncorrectConstException;
import exceptions.OverflowException;

public class ShortOperations implements Operation<Short>{
    @Override
    public Short parseConst(String number) throws IncorrectConstException {
        return (short) Integer.parseInt(number);
    }

    @Override
    public Short add(Short x, Short y) throws OverflowException {
        return (short)(x + y);
    }

    @Override
    public Short sub(Short x, Short y) throws OverflowException {
        return (short)(x - y);
    }

    @Override
    public Short mul(Short x, Short y) throws OverflowException {
        return (short)(x * y);
    }

    @Override
    public Short div(Short x, Short y) throws ExpressionException {
        return (short)(x / y);
    }

    @Override
    public Short not(Short x) throws OverflowException {
        return (short) -x;
    }

    @Override
    public Short abs(Short x) throws OverflowException {
        return (short)(Math.abs(x));
    }

    @Override
    public Short low(Short x) {
        return null;
    }

    @Override
    public Short high(Short x) {
        return null;
    }

    @Override
    public Short mod(Short x, Short y) {
        return (short)(x % y);
    }

    @Override
    public Short square(Short x) throws ExpressionException {
        return (short)(x * x);
    }
}
