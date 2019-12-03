package expressions;

import exceptions.OverflowException;
import operations.Operation;

public class Abs<T> extends AbstractUnaryOperator<T> {
    public Abs(final TripleExpression<T> x, final Operation<T> y) {
        super(x, y);
    }

    protected T apply(final T x) throws OverflowException {
        return op.abs(x);
    }
}
