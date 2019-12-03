package operations;

import exceptions.ExpressionException;
import exceptions.IncorrectConstException;
import exceptions.OverflowException;

public class UncheckedInteger implements Operation<Integer> {
    @Override
    public Integer parseConst(String number) throws IncorrectConstException {
        return Integer.parseInt(number);
    }

    @Override
    public Integer add(Integer x, Integer y) throws OverflowException {
        return x+y;
    }

    @Override
    public Integer sub(Integer x, Integer y) throws OverflowException {
        return x - y;
    }

    @Override
    public Integer mul(Integer x, Integer y) throws OverflowException {
        return x * y;
    }

    @Override
    public Integer div(Integer x, Integer y) throws ExpressionException {
        if (y == 0){
            throw new ExpressionException("Division by Zero");
        }
        return x/y;
    }

    @Override
    public Integer not(Integer x) throws OverflowException {
        return -x;
    }

    @Override
    public Integer abs(Integer x) throws OverflowException {
        return Math.abs(x);
    }

    @Override
    public Integer low(Integer x) {
        return null;
    }

    @Override
    public Integer high(Integer x) {
        return null;
    }

    @Override
    public Integer mod(Integer x, Integer y) {
        return x % y;
    }

    @Override
    public Integer square(Integer x) throws ExpressionException {
        return x * x;
    }
}
