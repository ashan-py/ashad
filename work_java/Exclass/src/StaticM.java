class Count {
    // 맨위에 필드위치하거라
    public static int scnt = 0;
    public int cnt = 0;

    public static void sIncre() {
        scnt++;
       
    }
    public void incre() {
        cnt++;
    }

}

public class StaticM {
    public static void main(String[] args) {
        Count c = new Count();
        Count s = new Count();
        
        c.incre();
        System.out.println("c.cnt = "+c.cnt);
        s.incre();
        s.incre();
        System.out.println("s.cnt = "+s.cnt);
        
        c.sIncre();
        System.out.println("c.scnt = "+c.scnt);
        System.out.println("s.scnt = "+s.scnt);
        Count.scnt = 3;

        System.out.println("\nCount.scnt = "+Count.scnt); //static은 공유할때도 쓰고 객체 없이 클래스에 접근하고 싶을때도 사용
        //System.out.println("\nCount.scnt = "+Count.cnt);
        Count.sIncre();//sIncre는 static이라서 객체없이 clsass에 접근해서 사용가능
        System.out.println("\nCount.scnt = "+Count.scnt);
        
    }

}

















