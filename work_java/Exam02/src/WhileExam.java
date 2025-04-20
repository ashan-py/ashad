import java.util.Scanner;

public class WhileExam {

    public static void main(String[] args) {
        int data, sum = 0, cnt = 0;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a int... Enter 0 to stop : ");
        while( ( data = scn.nextInt() ) != 0 ) {
            sum += data;
            cnt++;
            System.out.print("Enter a int... Enter 0 to stop : ");
        }
        scn.close();
        System.out.println("count of data = " + cnt);
        System.out.println("avg = "+ (double)sum/cnt);
        

    }

}
