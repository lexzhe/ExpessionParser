package exceptions;

public class IncorrectConstException extends ExpressionException {
    public IncorrectConstException (){
        super("Incorrect const value");
    }
}
