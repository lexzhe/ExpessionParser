package operations;

import exceptions.ExpressionException;
import exceptions.IncorrectConstException;
import exceptions.OverflowException;

import java.math.BigInteger;

public class BigIntegerOperations implements Operation<BigInteger> {
    @Override
    public BigInteger parseConst(String number) throws IncorrectConstException {
        try {
            return new BigInteger(number);
        } catch (NumberFormatException NFE) {
            throw new IncorrectConstException();
        }
    }

    @Override
    public BigInteger add(BigInteger x, BigInteger y) throws OverflowException {
        return x.add(y);
    }

    @Override
    public BigInteger sub(BigInteger x, BigInteger y) throws OverflowException {
        return x.subtract(y);
    }

    @Override
    public BigInteger mul(BigInteger x, BigInteger y) throws OverflowException {
        return x.multiply(y);
    }

    @Override
    public BigInteger div(BigInteger x, BigInteger y) throws ExpressionException {
        return x.divide(y);
    }

    @Override
    public BigInteger not(BigInteger x) throws OverflowException {
        return x.negate();
    }

    @Override
    public BigInteger abs(BigInteger x) throws OverflowException {
        return x.abs();
    }

    @Override
    public BigInteger low(BigInteger x) {
        return null;
    }

    @Override
    public BigInteger high(BigInteger x) {
        return null;
    }

    @Override
    public BigInteger mod(BigInteger x, BigInteger y) {

        return x.mod(y);
    }

    @Override
    public BigInteger square(BigInteger x) throws ExpressionException {
        return x.multiply(x);
    }
}
