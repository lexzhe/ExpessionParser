package expressions;

import exceptions.OverflowException;
import operations.Operation;



public class Low<T> extends AbstractUnaryOperator<T> {
    public Low(final TripleExpression<T> x, final Operation<T> y) {
        super(x, y);
    }

    protected T apply(final T x) throws OverflowException {
        return op.low(x);
    }
}
