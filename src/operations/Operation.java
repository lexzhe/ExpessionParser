package operations;

import exceptions.*;

public interface Operation<T> {
    T parseConst(final String number) throws IncorrectConstException;

    T add(final T x, final T y) throws OverflowException;

    T sub(final T x, final T y) throws OverflowException;

    T mul(final T x, final T y) throws OverflowException;

    T div(final T x, final T y) throws ExpressionException;

    //    T mod(final T x, final T y) throws IllegalOperationException;
//
    T not(final T x) throws OverflowException;

    T abs(final T x) throws OverflowException;

    T low(final T x);

    T high(final T x);

    T mod(final T x, final T y);

    T square(final T x) throws ExpressionException;

}
