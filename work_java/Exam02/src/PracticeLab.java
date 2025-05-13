/////이 파일이 src 즉 source파
//
//import java.util.Scanner;
/////스캐너 클래스 사용을 위한 imfort
//
//public class PracticeLab {
//    ///클래스 이름 대문자로 작성
//    ///하나의 프로그램에 public class가 하나만 있어야
//    public static final double PI = 3.141592;
//    /// 상수 선언 final이 사용됨
//    /// 선언시 초기값 지정
//    ///실행 중 값 변경 안됌
//    ///상수 이름 모든 글자가 대문자로 성되어야함
//    ///
//    ///final앞에 적힌 static = 정적 메소드 의미는 공유한다는 
//
//
//    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);//스캐너 적고 close도 해줘야
//        /// 스캐너 생성 int같이 크기가 정해져 있는 데이터 값은 선언 동시에 메모리가 할당되지만 
//        ///Scanner처럼 정해지지 않은 클래스는 new함수를 사용해 메모리 공간을 할당해줘야함 그리고 new뒤에 생성자(constructor)또한 써줘야함
//        
//        Boolean bol = false;//Boolean은 true false 1비트
//        char alpha = '가';//char는 문자 하나 유니코드 2바이트 자바는 유니코드사용
//        //2Byte = 16bit = 2^16 =  2^6 x 2^10 ~= 64 x 1000  = 64K
//        
//        byte by = 1; // byte는 1바이트 -128~127
//        short st = 2; //2바이트 -32768 ~ 32767
//        int nt = 4; //4바이트 -2^31 ~ 2^31 -1 정수형 주장 
//        long lg = 8; //8바이트, -2^63 ~ 2^63-1
//        ///여기서 자동타입 변환이 일어남 컴퓨터 입장에서8은 int 그런데 Long에 저장위해서 자동으로 int가 long으로 변환
//        ///반대로 강제 타입변환도 있는데 범위가 넘어갈시 값 손실 우려가 있다
//        
//        float ft = 4; //4바이트 -3.4E38 ~ 3.4E38 /E38 = 10^28
//        double db = 8; //8바이트 -1.7E308 ~ 1.7E308 실수형 주장 
//        
//        String str = "기본타입 아님";
//        ///변수 이름들이 소문자로 시작하는 모습 만약 두개의 단어가 합쳐졌다면 twoWor처럼 처음에는 소문자 다음단어에서 대문자
//        ///위에서 한것들이 변수 선언 즉 데이터 타입에서 정한 크기의 메모리를 할당해주는 
//        ///여기서 변수이름 클래스등에 붙이는 이름을 식별자라 하는데 식별자 헌법에는
//        ///1.특수문자, 공백, 탭을 사용해서는 안된다._ $ 는 가능 근데 걍 쓰지
//        ///2.유니코드 사용가능(즉 한글이 가능 그러나 한글은 잘 사용안함)
//        ///3. 시작을 숫자로 하지 않는다.
//        ///4.자바 언어의 키워드는 식별자로 사용안함
//        ///5.불린 리터널, null사용금지
//        ///6. 길이제한 없음
//        ///7.대소문자 구별함
//        ///대게 영어 숫자 _만 사용함
//        
//        var a = 3; 
//        /// java10부터 도입된 var키워드 
//        ///지역변수에만 쓸 수 있지만 변수의 타입을 컴파일러가 추론해서 결정한다는 장점이 있다
//        ///초기화 할때 초기값 없으면 오류
//        
//        System.out.print("정수형 리터널: "+3); //문자열이 포함되어있을때 + 는 연결해주는 역
//        ///정수 리터널이 들어간 모습 내가 입력한 상수3을 컴퓨터는 자동으로 int로 인식
//        ///리터널에는 정수 int로 받음 10,8,16,2진수 리터널이 존재 lon타입 리터널은 숫자뒤에 L를 붙임
//        ///        실수형 double로 받음 float사용하고 싶으면 숫자 뒤에f d도 사용가능하긴
//        ///        문자 리터널 유니코드로 특수 문자는 \로 시작
//        ///        논리값 리터널 c와 달리 1,0을 참,거짓으로 받지 않음 
//        ///        null리터널 int n = null; 오류남 기본타입에는 사용하면 안됌, String str = null;가능
//        ///        문자열 리터널 이중 인용부호 " "로 묶어서 표현 String객체로 자동처
//        ///        
//        
//        
//        
//        
//        while(a == 3) {
//            System.out.print("\n보고 싶은 타입을 입력하면 범위를 알려줄: ");
//            String re = scn.next();
//            ///스캐너를 이용하면 입력받은 값을 원하는 타입으로 받을 수 있음
//            ///문자열 next() = 공백기준으로 끊어서, nextline = \n이 나올때까지 받고 \n버림
//            ///정수 nextInt(), Long(), Byte(), Short()
//            ///실수 = nextDouble() nextFloat()
//            ///불런값 = nextBoolean
//            
//            printTypeRange(re, by, st, nt, lg, ft, db); // ← 여기!
//            
//            
//            System.out.print("다시할래? 할려면 3 입력");
//            a = scn.nextInt();
//               
//            }
//        
//        System.out.print("\n그리고 연산자에 대해서도 알아보자1234");
//        
//        int nl = scn.nextInt();
//        System.out.println(nl);
//        
//        
//        
//        if (nl == 1) {
//            System.out.println("||는 or 연산자");
//        }else if ((nl ==2)) System.out.println("&&는 and 연산자");
//            
//        else if (nl ==3) {
//            System.out.println("^는 xor 연산자");
//        }else if (nl == 4) {
//            System.out.println("시프트 연산자는 >> / >>>가 있어 >>는 최상위 비트를 따라가고 >>>는 빈자리를0으로 채워");
//        }
//        else {
//            System.out.println("연산자 입력");
//        }
//        for (int i = 1;i<=3;i++) {
//            System.out.println("이게 반복문이고3번반복해");
//        }
//        scn.close();
//    }
//    
//    public static void printTypeRange(String re, byte by, short st, int nt, long lg, float ft, double db) {
//        switch(re) {
//        case "byte":
//            System.out.println(by);
//            break;
//        case "short" :
//            System.out.println(st);
//            break;
//        case "int" :
//            System.out.println(nt);
//            break;
//        case "long" :
//            System.out.println(lg);
//            break;
//        case "float":
//            System.out.println(ft);
//            break;
//        case "double":
//            System.out.println(db);
//            break;
//        default:
//            System.out.println("다시 시작해라");
//            break;
//        ///switch때 case에 변수, 수식은 쓰면 안돼 
//        ///위 처럼 문자열이나 문자, 정수를 사용해야
//        }
//    }
//        
//    
//}
//        
//    
//
//

public class PracticeLab {

    public static void main(String[] args) {
        int i[] = new int[10];
        int j[] = {1,2,3,4,5};
        //i[1] = 10;
        System.out.print(j[1]);
        System.out.print(i[2]);
        int f[] = {};
        //int f[1] = 3;
        
        
    }

}
