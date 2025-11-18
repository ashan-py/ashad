#include <stdio.h>
#include <string.h>

// 가격 구조체 정의
struct sc {
    char name[10];
    int price;
};

// 종목과 가격 배열
struct sc sports[5] = {
    {"골프", 20000},
    {"수영", 17000},
    {"헬스", 12000},
    {"탁구", 10000},
    {"샤워", 5000}
};

// 가격 찾는 함수
int get_price(char* input_name) ;

// 영수증출력 함수
void print_customer_receipt(char names[][10], int qty[], int unit_price[], int total_price[], int count, int total, int money) ;

//매출전표
void print_sales_report(char names[][10], int qty[], int unit_price[], int total_price[], int count, int total);

int p_20() {
    char input[100];
    char items[10][20];     // 입력 항목 (골프4 등)
    char names[10][10];     // 종목 이름
    int qty[10];            // 수량
    int unit_price[10];     // 단가
    int total_price[10];    // 금액
    int total = 0, money;

    // 입력
    printf("주문내용을 입력하고 Enter> ");
    gets(input);

    // 공백 기준 분할
    int i = 0, j = 0, k = 0;
    while (input[i] != '\0') {
        if (input[i] == ' ') {
            items[j][k] = '\0';
            j++; k = 0;
        } else {
            items[j][k++] = input[i];
        }
        i++;
    }
    items[j][k] = '\0'; // 마지막 항목 처리
    int count = j + 1;

    // 종목/수량 분리 및 계산
    for (int a = 0; a < count; a++) {
        int m = 0;
        while (items[a][m] < '0' || items[a][m] > '9') {
            names[a][m] = items[a][m];
            m++;
        }
        names[a][m] = '\0';

        qty[a] = 0;
        while (items[a][m] != '\0') {
            qty[a] = qty[a] * 10 + (items[a][m] - '0');
            m++;
        }

        unit_price[a] = get_price(names[a]);
        total_price[a] = unit_price[a] * qty[a];
        total += total_price[a];
    }

    // 입금
    printf("금액을 입력하고 Enter> ");
    scanf("%d", &money);

    // 매출전표 출력
    print_customer_receipt(names, qty, unit_price, total_price, count, total, money);
    print_sales_report(names, qty, unit_price, total_price, count, total);
    return 0;
}
int get_price(char* input_name) {
    for (int i = 0; i < 5; i++) {
        if (strcmp(input_name,sports[i].name) == 0) {
            return sports[i].price;
        }
    }
    return 0;
}
void print_customer_receipt(char names[][10], int qty[], int unit_price[], int total_price[], int count, int total, int money) {
    printf("\n영수증\n");
    printf("종목\t수량\t단가\t\t금액\n");
    printf("--------------------------\n");
    for (int i = 0; i < count; i++) {
        if (unit_price[i] == 0)
            printf("%s\t오류\t0원\t0원 (잘못된 종목)\n", names[i]);
        else
            printf("%s\t%d\t%d원\t%d원\n", names[i], qty[i], unit_price[i], total_price[i]);
    }
    printf("\n총액 : %d원\n", total);
    printf("입금 : %d원\n", money);
    printf("잔돈 : %d원\n", money - total);
}
void print_sales_report(char names[][10], int qty[], int unit_price[], int total_price[], int count, int total) {
    printf("\n매출전표\n");
    printf("종목\t수량\t단가\t\t금액\n");
    printf("--------------------------\n");
    for (int i = 0; i < count; i++) {
        if (unit_price[i] == 0)
            printf("%s\t오류\t0원\t0원 (잘못된 종목)\n", names[i]);
        else
            printf("%s\t%d\t%d원\t%d원\n", names[i], qty[i], unit_price[i], total_price[i]);
    }
    printf("\n총액 : %d원\n", total);
}