//class Circle {
//    int radius;
//
//    public Circle(int radius) {
//        this.radius = radius;
//    }
//
//    public double getArea() {
//        return 3.14 * radius * radius;
//    }
//}

public class CircleArray {
    static class Circle {
        int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        public double getArea() {
            return 3.14 * radius * radius;
        }
    }

    public static void main(String[] args) {
        Circle[] c;
        c = new Circle[5]; // 객체 배열 생성 (참조 공간만 만듦)

        for (int i = 0; i < c.length; i++) {
            c[i] = new Circle(i); // 각 원소에 Circle 객체 생성 및 초기화
        }

        for (int i = 0; i < c.length; i++) {
            System.out.print((int) (c[i].getArea()) + " ");
        }
 
    }
}
