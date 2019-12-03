package operations;

import exceptions.ExpressionException;
import exceptions.IncorrectConstException;
import exceptions.OverflowException;

public class ByteOperations implements Operation<Byte>{
    @Override
    public Byte parseConst(String number) throws IncorrectConstException {
        try {
            return (byte) Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IncorrectConstException();
        }
    }

    @Override
    public Byte add(Byte x, Byte y) throws OverflowException {
        return (byte) (x+y);
    }

    @Override
    public Byte sub(Byte x, Byte y) throws OverflowException {
        return (byte) (x-y);
    }

    @Override
    public Byte mul(Byte x, Byte y) throws OverflowException {
        return (byte) (x*y);
    }

    @Override
    public Byte div(Byte x, Byte y) throws ExpressionException {
        if (y == 0){
            throw new ExpressionException("Division by zero");
        }
        return (byte) (x/y);
    }

    @Override
    public Byte not(Byte x) throws OverflowException {
        return (byte) (-x);
    }

    @Override
    public Byte abs(Byte x) throws OverflowException {
        return (byte) Math.abs(x);
    }

    @Override
    public Byte low(Byte x) {
        return null;
    }

    @Override
    public Byte high(Byte x) {
        return null;
    }

    @Override
    public Byte mod(Byte x, Byte y) {
        return (byte) (x % y);
    }

    @Override
    public Byte square(Byte x) throws ExpressionException {
        return (byte) (x*x);
    }
}
