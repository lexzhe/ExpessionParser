package parser;

import exceptions.ExpressionException;
import expressions.TripleExpression;
import operations.*;

public class GenericTabulator implements Tabulator {
    Object[][][] res;
    static Operation<?> myOperation;
    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {


        switch (mode) {
            case "i": {
                myOperation = new IntegerOperations();
                break;
            }
            case "d": {
                myOperation = new DoubleOperations();
            }
            case "bi": {
                myOperation = new BigIntegerOperations();
                break;
            }
            case "u": {
                myOperation = new UncheckedInteger();
                break;
            }
            case "f": {
                myOperation = new FloatOperations();
                break;
            }
            case "b": {
                myOperation = new ByteOperations();
                break;
            }
            case "l": {
                myOperation = new LongOperations();
                break;
            }
            case "s": {
                myOperation = new ShortOperations();
                break;
            }
            default: {
                myOperation = new IntegerOperations();
                break;
            }
        }
        return tabulate(myOperation, expression, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] tabulate(Operation<T> myOperation, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws ExpressionException {
        ExpressionParser<T> myParser = new ExpressionParser<T>(myOperation);
        TripleExpression<T> parsedExpression = myParser.parse(expression);
        int dx = x2 - x1 + 1;
        int dy = y2 - y1 + 1;
        int dz = z2 - z1 + 1;
        res = new Object[dx][dy][dz];

        for (int i = 0; i < dx; i++) {
            for (int j = 0; j < dy; j++) {
                for (int k = 0; k < dz; k++) {
//                    try {
//                        res[i][j][k] = parsedExpression.evaluate(x1 + i, y1 + j, z1 + k);
//                    }catch (ExpressionException a){
//                        res[i][j][k] = null;
//                    }
                    try {
                        res[i][j][k] = parsedExpression.evaluate(myOperation.parseConst(Integer.toString(x1 + i)),
                                myOperation.parseConst(Integer.toString(y1 + j)), myOperation.parseConst(Integer.toString(z1 + k)));
                    } catch (Exception e) {
                        res[i][j][k] = null;
                    }
//                    System.out.print(res[i][j][k] + " ");
                }
//                System.out.println();
            }
//            System.out.println();

        }
        return res;
    }
    public void printCell(int x, int y, int z){
        System.out.println(res[x][y][z]);
    }
    public void printTable(){
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < res[0][0].length; k++) {
                    System.out.print(res[i][j][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
