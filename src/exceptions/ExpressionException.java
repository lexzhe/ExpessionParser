package exceptions;

public class ExpressionException extends Exception{

    public ExpressionException() {
        super("There is an error!!");
    }

    public ExpressionException(String errorMessage){
        super(errorMessage);
    }
    public ExpressionException(String errorMessage, int pos, String expression){
        super(errorMessage+ "\n" + expression + "\n" + showPosition(pos));
    }
    private static String showPosition(int pos){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            res.append(' ');
        }
        res.append('^');
        res.append(" here");
        return res.toString();
    }
}
