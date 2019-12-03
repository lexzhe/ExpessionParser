package expressions;

import exceptions.OverflowException;
import operations.Operation;

public class Add<T> extends AbstractBinaryOperator<T> {
    public Add(final TripleExpression<T> x, final TripleExpression<T> y, final Operation<T> z) {
        super(x, y, z);
    }

    protected T apply(final T x, final T y) throws OverflowException {
        return op.add(x, y);
    }
}
