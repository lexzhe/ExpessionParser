package operations;


import exceptions.ExpressionException;
import exceptions.IncorrectConstException;
import exceptions.OverflowException;

public class LongOperations implements Operation<Long> {
    @Override
    public Long parseConst(String number) throws IncorrectConstException {
        return Long.parseLong(number);
    }

    @Override
    public Long add(Long x, Long y) throws OverflowException {
        return x + y ;
    }

    @Override
    public Long sub(Long x, Long y) throws OverflowException {
        return x - y;
    }

    @Override
    public Long mul(Long x, Long y) throws OverflowException {
        return x * y;
    }

    @Override
    public Long div(Long x, Long y) throws ExpressionException {
        return x / y;
    }

    @Override
    public Long not(Long x) throws OverflowException {
        return -x;
    }

    @Override
    public Long abs(Long x) throws OverflowException {
        return Math.abs(x);
    }

    @Override
    public Long low(Long x) {
        return null;
    }

    @Override
    public Long high(Long x) {
        return null;
    }

    @Override
    public Long mod(Long x, Long y) {
        return x % y;
    }

    @Override
    public Long square(Long x) throws ExpressionException {
        return x * x;
    }
}
