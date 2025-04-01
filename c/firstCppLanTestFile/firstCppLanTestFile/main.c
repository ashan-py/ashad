//
//  main.cpp
//  firstCppLanTestFile
//
//  Created by 강병진 on 3/11/25.
//

#include <stdio.h>
int main(void)
{
    printf("%d+%d=%d\n", 9, 5, 14);
    printf("탈주마렵네\n");
    printf("키는 %f cm\n", 175.3);
    printf("키는 %.1f cm\n", 175.3);
    
    
    double a = 0.64;
    const double b = 0.4223;
    const double c = 12.6732;
    const double d = -6.3634;
    a = a + b;
    
    
    printf("%.0f\n", a);
    printf("%.1f\n", b);
    printf("%.2f\n", c);
    printf("%.3f\n", d);
    //0f, 1f, 2f, nf 등은 소숫점 n+1 번째에서 반올림한 후 n번째 자리 까지만 나타낸다.
    printf("%d+%d=%d\n", 7, 8, 7+8);
    ///%d는 10진 정수형
    ///printf("%d\n이다.", "강병진");
    ///따라서 이런식으로 문자열이 들어갈 수 없다
    printf("내 학점은 %c이다\n", 'A');
    ///c는 문자형 상수 오직 영어 한 글자만이 들어갈 수 있음.
    ///그리고 ,뒤에 문자형 상수 앞 뒤에는 작은 따옴표 ' ' 가 들어감
    printf("과목 : %s\n","C programing");
    ///%s은 strinig 문자열형 상수를 문자열로 출력가능
    ///문자열 상수 앞뒤에는 " " 들어감
    printf("내학점은 %#08x\n", 9);
    int e = 5;
    // 변수 선언
    const int f = 6;
    // 상수 선언
    const char name[] = "강병진";
    printf("내 이름은 %s\n", name);
    //c는 따로 stirng이 없어서 char A[] = " " 형식으로 문자열을 저장
    e = e + f ;
    printf("%d\n", e);
    /// lf = double
    char ch1 = 'A';
    char ch2 = 1.14;
    printf("ch1의 문자값 %c\n", ch1);
    ch2 = ch2 + 1;
    printf("%d\n", ch2);
    
}
