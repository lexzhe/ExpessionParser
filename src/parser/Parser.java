package parser;

import exceptions.*;
import expressions.TripleExpression;

public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws ExpressionException;
}