// 양의 두 정수를 입력받아 최대공약수 & 최소공배수 구하기
// using BufferedReader class 사용

import java.io.*;

public class GcdLcdBfrd {

    public static void main(String[] args) throws IOException {
        int num1, num2, gcd, lcd;

        BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("첫번째 정수 입력: ");
//        num1 = Integer.parseInt(bfrd.readLine());// parseInt = readLine으로 입력받은 문자를 숫자로 바꿔주는 놈
        // System.out.println(num1);

//        System.out.print("두번째 정수 입력: ");
//        num2 = Integer.parseInt(bfrd.readLine());
        // System.out.println(num2);
//        
//        System.out.print("input a double: ");
//        double dbl = Double.parseDouble(bfrd.readLine());
//        System.out.println(dbl);

//        System.out.print("input string: ");
//        String str = bfrd.readLine();
//        System.out.println(str);
        // 위랑 다르게 str은 어짜피 string을 받아온거라 구문검사 할필요 없음.

        System.out.print("input a char: ");
        char c = (char) bfrd.read(); // 문자를 받고 반환은 int로 반환
        System.out.println(c);
        bfrd.close();

//        gcd = gcdFind(num1,num2);
//        lcd = (num1/gcd)*(num2/gcd)*gcd;
//        System.out.println("gcd = "+gcd+",lcd = "+lcd);

    }

    static int gcdFind(int num1, int num2) {
        while (num1 != num2)
            if (num1 > num2)
                num1 -= num2;
            else
                num2 -= num1;
        return num1;        

    }

}
