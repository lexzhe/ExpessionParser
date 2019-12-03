package parser;

import exceptions.ExpressionException;
import exceptions.OverflowException;

enum Token {
    NUM, VAR, ABS, SQR, ADD, SUB, DIV, MULT, MOD, OPEN_BRACE, CLOSE_BRACE, END, BEGIN, NEG, HIGH, LOW
}

public class Tokenizer {
    private char[] bufChars;
    private int index;
    public int lastValue;
    public String newConst;
    public Token curToken;
    private Token prevToken;
    public char lastVar;
    private String expression;


    public Tokenizer(String s) throws ExpressionException {
        bufChars = s.toCharArray();
        expression = s;
        index = 0;
        curToken = Token.BEGIN;
    }

    public String getExpression() {
        return expression;
    }

    public int getIndex() {
        return index;
    }

    private void skipWhiteSpace() {
        while (index < expression.length() && Character.isWhitespace(expression.charAt(index))) {
            index++;
        }
    }

    public Token getCurrentToken() {
        return curToken;
    }
    public Token getNextToken() throws ExpressionException{
        nextToken();
        return curToken;
    }

    public void nextToken() throws ExpressionException {
        skipWhiteSpace();
        if (index >= expression.length()) {

            curToken = Token.END;
            return;
        }

        char c = bufChars[index++];
//        if (Character.isDigit(c) || (c == '-' && !(!Character.isDigit(bufChars[index]) || curToken == Token.VAR
//                || curToken == Token.NUM || curToken == Token.CLOSE_BRACE))) {
        if ((Character.isDigit(c))) {
            NumberToken(c);
        } else if (Character.isLetter((c))) {
            WordToken(c);
        } else {
            SymbolToken(c);
        }
//        checkPreviouseToken( index);
    }

    private void NumberToken(char c) throws OverflowException {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        for (; index < bufChars.length && Character.isDigit(bufChars[index]); index++) {
            sb.append(bufChars[index]);
        }
        try{
            lastValue = Integer.parseInt(sb.toString());
            newConst = sb.toString();
            curToken = Token.NUM;
        }catch(NumberFormatException e){
            throw new OverflowException();
        }

    }

    private void WordToken(char c) throws ExpressionException {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        for (; index < bufChars.length && Character.isLetter(bufChars[index]); index++) {
            sb.append(bufChars[index]);
        }
//        if (sb.toString().equals("count")) {
//            curToken = Token.COUNT;
//        } else {
//            lastVar = sb.toString();
//            curToken = Token.VAR;
//        }

        switch (sb.toString()) {

            case "x":
            case "y":
            case "z":

                curToken = Token.VAR;
                lastVar = sb.toString().charAt(0);
                return;
            case "abs":
                curToken = Token.ABS;
                return;
            case "square":
                curToken = Token.SQR;
                return;
            case "mod":
                curToken = Token.MOD;
                return;
            case "high":
                curToken = Token.HIGH;
                return;
            case "low":
                curToken = Token.LOW;
                return;
            default:
                throw new ExpressionException("Illegal word", index, expression);
        }

    }

    private void SymbolToken(char c) throws ExpressionException {
        switch (c) {

            case '+':
                curToken = Token.ADD;
                return;
            case '/':
                curToken = Token.DIV;
                return;
            case '*':
                curToken = Token.MULT;
                return;
            case '(':
                curToken = Token.OPEN_BRACE;
                return;
            case ')':
                curToken = Token.CLOSE_BRACE;
                return;
            case '-':
                if (curToken == Token.CLOSE_BRACE || curToken == Token.VAR || curToken == Token.NUM) {
                    curToken = Token.SUB;
                } else {
                    if (index + 1 > expression.length()) {
                        throw new ExpressionException("Missing operand "+index, index, expression);
                    } else if (Character.isDigit(expression.charAt(index))) {
                        NumberToken(c);
                        return;
                    } else {
                        curToken = Token.NEG;
                        return;
                    }
                }
                curToken = Token.SUB;
                return;
            default:

//                if (index < bufChars.length) {
//                    if (Character.isWhitespace(c)) {
//                        nextToken();
//                    } else {
//                        throw new ExpressionException("Illegal character", index, expression);
//                    }
//                } else {
//                    curToken = Token.END;
//                }
                throw new ExpressionException("Illegal character", index, expression);
        }
    }

//    private void checkPreviousToken(final int pos) {
//        if (isBinOperation())
//        switch (curToken){
//
//        }
//    }
//
//    private void checkOperand(final int pos) throws ExpressionException {
//        if (isOperation() || curToken == Token.OPEN_BRACE || curToken == Token.BEGIN) {
//            throw new ExpressionException("Missing operand", pos, expression);
//        }
//    }
//
//    private void checkForOperation(final int pos) throws ExpressionException {
//        if (curToken == Token.CLOSE_BRACE || curToken == Token.VAR || curToken == Token.NUM) {
//            throw new ExpressionException("Missing operation", pos, expression);
//        }
//    }
//
//    private boolean isBinOperation(Token token) {
//        switch (token) {
//            case ADD:
//            case SUB:
//            case MULT:
//            case DIV:
//                return true;
//            default:
//                return false;
//
//        }
//    }
//
//    private boolean isOperation(Token token) {
//        if (isBinOperation(token)) return true;
//        switch (token) {
//            case NEG:
//                return true;
//            case SQR:
//                return true;
//            case ABS:
//                return true;
//            case MOD:
//                return true;
//            default:
//                return false;
//        }
//    }


}
