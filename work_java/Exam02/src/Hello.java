
public class Hello {

    public static void main(String[] args) {
        int i = 20;
        int s = 3;
        System.out.print(s);
        char c;

        //s = i + 10;
        s = sum(i, 10);
        c = '?';
        System.out.println(c);
        System.out.println("Hello");
        System.out.print(s);

    }
    public static int sum(int n, int m) {
        return n + m;
        
    }

}
///실행속도 빠르고 메모리 적게 차지하는게 좋
///static = 정적 메소드 의미는 공유
///메인 메소드는 무조건 static
