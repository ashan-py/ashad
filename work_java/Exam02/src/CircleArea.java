
public class CircleArea {
    public static final double PI = 3.141592;
    
    static double area(int radius) {
        return PI * radius * radius;
       
    }

    public static void main(String[] args) throws java.io.IOException {
       int radius = 10;
       
       System.out.print("반지름 입력 : ");
       radius = System.in.read()-'0';
       System.out.print(radius);
       //read 메소드는 키보드로 부터 단 하나의 문자만을 받아오고 그걸 유니코드로 저장
       
       //double circleArea = PI * radius * radius;
       double circleArea = area(radius);
       
       System.out.print("반지름 = " + radius + ", ");
       System.out.print("원의 면적 = " +circleArea);
       
    }

}
