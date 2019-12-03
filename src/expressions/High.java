package expressions;

import exceptions.OverflowException;
import operations.Operation;



public class High<T> extends AbstractUnaryOperator<T> {
    public High(final TripleExpression<T> x, final Operation<T> y) {
        super(x, y);
    }

    protected T apply(final T x) throws OverflowException {
        return op.high(x);
    }
}