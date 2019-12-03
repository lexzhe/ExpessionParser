package exceptions;

public class ParsingException extends ExpressionException{
    public ParsingException(final int pos, String expression){
        super("Parsing error",pos, expression);
    }
}
