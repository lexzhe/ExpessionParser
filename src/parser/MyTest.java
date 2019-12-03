package parser;

import exceptions.ExpressionException;
import operations.*;

public class MyTest {
    public static void main(String[] args) throws Exception {
        GenericTabulator tabulator = new GenericTabulator();
        Object[][][] kek = tabulator.tabulate("l", "x - y + z" , -2147483648, -2147483645 ,-2147483648, -2147483633, -2147483648, -2147483645);
        tabulator.printTable();
//        System.out.println(kek[1][1][1]);
//        tabulator.printCell(1,0,0);
    }
}
