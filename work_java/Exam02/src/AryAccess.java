//0의 정수 5개 입력받아 제일 큰 수 구하기

import java.util.Scanner;

public class AryAccess {
    // 정수 배열을 생성하고 입력받아 초기화하는 메소드(makeAry())
    static int[] makeAry(int len) {
        int[] intAry = new int[len];

        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < intAry.length; i++) {
            System.out.print("정수 입력하시오 " + (i + 1) + "번째 pos int of 5 insts: ");
            intAry[i] = scn.nextInt();

        }
        scn.close();
        return intAry;
    }

    public static void main(String[] args) {
//        int[] intAry = new int[5];
//        
//        Scanner scn = new Scanner(System.in);
//        for (int i=0;i<intAry.length;i++) {
//            System.out.print("정수 입력하시오 "+(i+1) +"번째 pos int of 5 insts: ");
//            intAry[i] = scn.nextInt();
//            
//        }
//        scn.close();

        int len = 5;
        int[] intAry;
        intAry = makeAry(len);
        System.out.print("[ ");
        for (int i = 0; i < intAry.length; i++)
            System.out.print(intAry[i] + ", ");
        System.out.println("]");

        int max = 0; // 가장 작은 정수

//        for (int i=0; i<intAry.length;i++) {
//            if (intAry[i] > max) {
//                max = intAry[i];
//            }
//        }
        for (int i : intAry) {
            if (i > max) {
                max = i;
            }
        }
        System.out.print(max);
    }

}
