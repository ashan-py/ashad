import java.util.Scanner;

public class Gugu {
    public static void main(String[] args) {
        int dan;
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.print("2~6 사이 정수 입력하세요");
            dan = scn.nextInt();
            if (2<= dan && dan<=6) {
                break;
            }else {
                System.out.println("안되지롱 2~6 사이 정수 입력해야");
            }
            
        }
        scn.close();
        for (int i = 1; i<=9; i++) {
            System.out.printf("%d*%d=%2d\n", dan, i, dan*i);
        }
    }

}
