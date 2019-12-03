package expressions;

import exceptions.ExpressionException;
import exceptions.OverflowException;
import operations.Operation;

public class Square<T> extends AbstractUnaryOperator<T> {
    public Square(final TripleExpression<T> x, final Operation<T> y) {
        super(x, y);
    }

    protected T apply(final T x) throws ExpressionException {
        return op.square(x);
    }
}
