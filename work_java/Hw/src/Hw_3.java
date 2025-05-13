import java.util.Scanner;

public class Hw_3 {
    static int[] makeAry(int len) {
        int[] intAry = new int[len];
        
        Scanner scn = new Scanner(System.in);
        for (int i:intAry) {
            System.out.print("정수 입력하시오 "+(i+1) +"번째 pos int of 5 insts: ");
            i = scn.nextInt();
            
        }
        scn.close();
        return intAry;
      }

    public static void main(String[] args) {
        int len = 5;
        int[] intAry;
        intAry = makeAry(len);
        
        System.out.print("[ ");
        for (int i:intAry) {
            System.out.print(i+", ");
        }
        System.out.println("]");
        
        int max=0; 
        for (int i: intAry) {
            if (i > max) {
                max = i;
            }
        }
        System.out.print(max);
    }


    }


