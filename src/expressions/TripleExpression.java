package expressions;

import exceptions.ExpressionException;

public interface TripleExpression<T> {
    T evaluate(T x, T y, T z) throws ExpressionException;
}
