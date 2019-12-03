package parser;

import expressions.*;
import exceptions.*;
import operations.*;


public class ExpressionParser<T> implements Parser {
    private Tokenizer tokenizer;
    private Operation<T> operation;

    public ExpressionParser(final Operation<T> x) {
        operation = x;
    }


    private TripleExpression unary() throws ExpressionException {
        TripleExpression currentResult;

        switch (tokenizer.getNextToken()) {
            case NUM:
//                currentResult = new Const(tokenizer.lastValue);
                currentResult = new Const(operation.parseConst(tokenizer.newConst));
                tokenizer.getNextToken();
                break;
            case VAR:
                currentResult = new Variable<T>(tokenizer.lastVar);
                tokenizer.getNextToken();
                break;
            case NEG:
                currentResult = new Negate<T>(unary(), operation);
                break;
            case HIGH:
                currentResult = new High<T>(unary(), operation);
                break;
            case LOW:
                currentResult = new Low<T>(unary(), operation);
                break;
            case ABS:
                currentResult = new Abs<T>(unary(), operation);
                break;
            case SQR:
                currentResult = new Square<T>(unary(), operation);
                break;
            case OPEN_BRACE:
                currentResult = addSub();
                if (tokenizer.getCurrentToken() != Token.CLOSE_BRACE) {
                    throw new ExpressionException("Missing close brace", tokenizer.getIndex(), tokenizer.getExpression());
                }
                tokenizer.getNextToken();
                break;
//            case HIGH:
//                currentResult = new High(unary());
//                break;
//            case LOW:
//                currentResult = new Low(unary());
//                break;
            case END:

            default:
                throw new ParsingException(tokenizer.getIndex(), tokenizer.getExpression());
        }
        return currentResult;
    }


//    private TripleExpression logAndPow() throws ParsingException {
//        TripleExpression currentResult = unary();
//        while (true) {
//            switch (tokenizer.getCurrentToken()) {
//                case LOG:
//                    currentResult = new CheckedLog(currentResult, unary());
//                    break;
//                case POW:
//                    currentResult = new CheckedPow(currentResult, unary());
//                    break;
//                default:
//                    return currentResult;
//            }
//        }
//    }

    private TripleExpression<T> mulDivMod() throws ExpressionException {
        TripleExpression currentResult = unary();
        while (true) {
            switch (tokenizer.getCurrentToken()) {
//                case MULT:
//                    currentResult = new Multiply(currentResult, logAndPow(), operation);
//                    break;
//                case DIV:
//                    currentResult = new Divide(currentResult, logAndPow(), operation);
//                    break;
//                default:
//                    return currentResult;
                case MULT:
                    currentResult = new Multiply(currentResult, unary(), operation);
                    break;
                case DIV:
                    currentResult = new Divide(currentResult, unary(), operation);
                    break;
                case MOD:
                    currentResult = new Mod(currentResult, unary(), operation);
                default:
                    return currentResult;
            }
        }
    }

    private TripleExpression addSub() throws ExpressionException {
        TripleExpression currentResult = mulDivMod();
        while (true) {
            switch (tokenizer.getCurrentToken()) {
                case ADD:
                    currentResult = new Add(currentResult, mulDivMod(), operation);
                    break;
                case SUB:
                    currentResult = new Subtract(currentResult, mulDivMod(), operation);
                    break;
                default:
                    return currentResult;
            }
        }
    }

    public TripleExpression parse(final String expression) throws ExpressionException {
        assert expression != null : "Expression is null";

        tokenizer = new Tokenizer(expression);
        return addSub();
    }
}