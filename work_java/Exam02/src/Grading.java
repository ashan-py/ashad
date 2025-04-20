import java.util.Scanner;

public class Grading {

    public static void main(String[] args) {
        char grade;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter your score: ");
        int score = scn.nextInt();
        score = score/10;
        switch(score) {
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
       
        }
        System.out.println("당신의 학점은 "+grade+"입니다.");
        
        scn.close();
    }

}
