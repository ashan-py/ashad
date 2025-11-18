//두 정수를 입력받아 몫구하

import java.util.Scanner;

public class DivByZero {
    public static void main(String[] args) {
        int dividend, divisor;
        
        Scanner scn = new Scanner(System.in);
        System.out.print("input a dividend: ");
        dividend = scn.nextInt();
        System.out.print("input a divisor: ");
        divisor = scn.nextInt();
        
        
        try {
            System.out.print(dividend+"/"+ divisor +",quatient = "+dividend/divisor);
        }
        catch(ArithmeticException e) { //e = exception
            System.out.println("Divided by zero T.T...");
        }
        finally {
            scn.close();
        }
        
        //try catch finally 문에서는 무조건 중괄호 달아야 댐 
        
    }

}
