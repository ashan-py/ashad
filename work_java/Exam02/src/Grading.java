import java.util.Scanner;

public class Grading {

    public static void main(String[] args) {
        char grade;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter your score: ");
        int score = scn.nextInt();
        score/=10;
        grade = decide(score);
        System.out.println("당신의 학점은 "+grade+"입니다.");
        
        scn.close();
    }
    static char decide(int score) {
        
        switch(score) {
        case 10: case 9:
            return 'A';
            
        case 8:
            return 'B';
        case 7:
            return 'C';
            
        case 6:
            return 'D';
            
        default:
            return 'F';

        }
    }

}

