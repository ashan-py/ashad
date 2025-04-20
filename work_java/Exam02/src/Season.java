import java.util.Scanner;

public class Season {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        ///import 쓸때 command shift o
        System.out.print("Enter a month(1~12): ");
        int month = scn.nextInt();
        switch(month) {
            case 1: case 2: case 12:
                System.out.println("It's winter.");
                break;
            case 3: case 4: case 5:
                System.out.println("It's spring.");
                break;
            case 6: case 7: case 8:
                System.out.println("It's summer.");
                break;
            case 9: case 10: case 11:
                System.out.println("It's autumn.");
                break;
            default:
                System.out.println("mis-input, re-input 1~12");
                
                    
        }
        
        scn.close();
        
    }

}
