
public class Circle {
    int radius;
    String name;
    
    
    public double getArea() {
        return Math.pow(radius, 2)*Math.PI; 
        //Math.pow(a,b) = a^b
    }

    public static void main(String[] args) {
        //컴파일 되면 메인메소드 먼저 실행됌
        Circle pizza = new Circle();
        pizza.name = "java pizza";
        pizza.radius = 10;
        double area = pizza.getArea();
        System.out.println(pizza.name+"의 면적 = "+area);

    }

}
