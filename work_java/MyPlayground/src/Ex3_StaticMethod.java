class Count {
    public static int scount = 0; // 클래스(static) 변수
    int count = 0;         // 인스턴스 변수

    public static void sIncrement() {
        scount++;
    }

    public void increment() {
        count++;
    }
}

public class Ex3_StaticMethod {
    public static void main(String[] args) {
        Count c = new Count();
        Count d = new Count();

        c.increment();           // c.count = 1
        Count.sIncrement();      // scount = 1

        d.increment();           // d.count = 1
        d.sIncrement();          // scount = 2

        System.out.print("Instance Value: c.count = " + c.count);
        System.out.println(", Static Value: c.scount = " + c.scount);

        System.out.print("Instance Value: d.count = " + d.count);
        System.out.println(", Static Value: Count.scount = " + Count.scount);

        System.out.println("Shared Value ? " + (c.scount == d.scount));
    }
}