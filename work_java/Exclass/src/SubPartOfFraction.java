class Fraction {
    // field
    int numerator; // 분자
    int denominator; // 분모

    Fraction() {
        this.numerator = 0;
        this.denominator = 1;

    }

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // method
    public void prtFraction() {
        System.out.print("prtFracton() is called.: ");
        System.out.printf("%d / %d\n", numerator, denominator);
    }

    public void prtFraction(int i) {
        System.out.print("prtFracton(int) is called.: ");
        System.out.printf("%d / %d\n", numerator, denominator);
    }

    public void prtFraction(double d) {
        System.out.print("prtFracton(double) is called.: ");
        System.out.printf("%d / %d\n", numerator, denominator);
    }
    public String toString() {
        String str = numerator +"/"+ denominator;
        return str;
        
    }
}

public class SubPartOfFraction {

    public static void main(String[] args) {
        Fraction frac0 = new Fraction(); // 컨스트럭터 따로 안만들따로 조치 취하지 않으면 컴파일러가 자동으로 필드를 0으로 초기화
//        frac0.prtFraction();
//        
        Fraction frac = new Fraction(1, 2);
//        frac.prtFraction();
//        frac.prtFraction(3);
//        frac.prtFraction(3.14);

        System.out.println("frac = " + frac); 
        System.out.print("flac0" + frac0);
        /// Fraction class에 public String toString없을때 실행하면 
        /// frac = Fraction@587c290d 나옴 Fraction class는 587c290d에 위치(@ = at)
        /// public String toString 있으면 frac이 자동으로 frac.toString으로 실행됨
        /// public String toString 매소드는 무조건 public에 데이터 타입은 String 이어야
        

    }

}
