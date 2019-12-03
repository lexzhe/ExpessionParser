package expressions;

import exceptions.OverflowException;
import operations.Operation;



public class Negate<T> extends AbstractUnaryOperator<T> {
    public Negate(final TripleExpression<T> x, final Operation<T> y) {
        super(x, y);
    }

    protected T apply(final T x) throws OverflowException {
        return op.not(x);
    }
}
