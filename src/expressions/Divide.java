package expressions;

import exceptions.ExpressionException;
import operations.Operation;

public class Divide<T> extends AbstractBinaryOperator<T> {
    public Divide(final TripleExpression<T> x, final TripleExpression<T> y, final Operation<T> z) {
        super(x, y, z);
    }

    protected T apply(final T x, final T y) throws ExpressionException {
        return op.div(x, y);
    }
}
