package expressions;

import exceptions.OverflowException;
import operations.Operation;

public class Mod<T> extends AbstractBinaryOperator<T> {
    public Mod(final TripleExpression<T> x, final TripleExpression<T> y, final Operation<T> z) {
        super(x, y, z);
    }

    protected T apply(final T x, final T y) throws OverflowException {
        return op.mod(x, y);
    }
}
