import java.util.Scanner;

public class ScannerEx {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner;
        scanner = new Scanner(System.in);
//        System.out.print("input your name: ");
//        String name = scanner.next();
//        System.out.println("name = "+name);
//        
//        System.out.print("input your age: ");
//        int age = scanner.nextInt();
//        System.out.print("age = "+age);
//        scanner.close();
//        
//        System.out.print("input your weight: ");
//        double weight  = scanner.nextDouble();
//        System.out.print("weight = "+weight);
//        
//        System.out.print("Are Ua a student?(true/false): ");
//        boolean student = scanner.nextBoolean();
//        System.out.print("Student? = "+student);
//        scanner.close();
        System.out.print("Enter a char: ");
        char ch = scanner.next().charAt(0);
        System.out.print("char = "+ch);
        scanner.nextLine(); 
        /// ch는 문자 하나만 받아오기 때문에 enter를 칠때 \n가 다음 입력으로 넘어가 의도치 않은 상황이 발생할 수 있는데 
        /// 이를 방지하기 위해 char 다음에 nextline으로 \n를 받기만 해서 버려줌 
        
        scanner.close();

    }

}
