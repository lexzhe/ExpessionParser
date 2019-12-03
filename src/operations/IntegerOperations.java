package operations;

import exceptions.*;


public class IntegerOperations implements Operation<Integer> {
    //    public boolean error = false;
    @Override
    public Integer parseConst(String number) throws IncorrectConstException {
//        Integer value = null;
//        for (int i = 0; i < number.length(); i++) {
//            if (!Character.isDigit(number.charAt(i))) {
//                throw new IncorrectConstException();
//            }
//
//        }
//        try {
//            value = Integer.parseInt(number);
//        } catch (NumberFormatException e) {
//            throw new ExpressionException("Too long const");
////            error = true;
//        } finally {
//            return value;
//        }
        int value;
        try {
            value = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IncorrectConstException();
        }
        return value;
    }

    @Override
    public Integer add(Integer x, Integer y) throws OverflowException {
        if ((x > 0) && (y > 0)) {
            if (x > Integer.MAX_VALUE - y) {
                throw new OverflowException();

            }
        }
        if ((x < 0) && (y < 0)) {
            if (x < Integer.MIN_VALUE - y) {
                throw new OverflowException();

            }
        }

        return x + y;
    }

    @Override
    public Integer sub(Integer x, Integer y) throws OverflowException {
        if ((x > 0) && (y < 0)) {
            if (x > Integer.MAX_VALUE + y) {
                throw new OverflowException();
            }
        }
        if ((x < 0) && (y > 0)) {
            if (x < -Integer.MAX_VALUE + y) {
                throw new OverflowException();

            }
        }

        return x - y;
    }

    @Override
    public Integer mul(Integer x, Integer y) throws OverflowException {
        if ((x > 0) && (y > 0)) {
            if (x > Integer.MAX_VALUE / y) {
                throw new OverflowException();

            }
        }
        if ((x < 0) && (y < 0)) {
            if (x < Integer.MAX_VALUE / y) {
                throw new OverflowException();

            }
        }
        if ((x < 0) && (y > 0)) {
            if (x < -Integer.MAX_VALUE / y) {
                throw new OverflowException();

            }
        }
        if ((x > 0) && (y < 0)) {
            if (x > -Integer.MAX_VALUE / y) {
                throw new OverflowException();

            }
        }

        return x * y;
    }

    @Override
    public Integer div(Integer x, Integer y) throws ExpressionException {
        if (y ==0){
            throw new ExpressionException("Division by zero");
        }
        return (int) x / y;
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
        return Integer.lowestOneBit(x);
    }

    @Override
    public Integer high(Integer x) {
        return Integer.highestOneBit(x);
    }

    @Override
    public Integer mod(Integer x, Integer y) {
        return x % y;
    }

    @Override
    public Integer square(Integer x) throws ExpressionException {
        if (x> Math.sqrt(Integer.MAX_VALUE)||x<=-Math.sqrt(Integer.MAX_VALUE)) throw new OverflowException();
        return x * x;
    }
}
