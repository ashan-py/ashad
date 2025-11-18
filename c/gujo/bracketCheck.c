//
// Created by 강병진 on 25. 10. 3.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STACK_SIZE 100
typedef char element;   // 이제 char로 바꿔줌 → 괄호 문자 저장하기 용이

typedef struct {
    element data[MAX_STACK_SIZE];
    int top;
} StackType;

// 스택 초기화
void init_stack(StackType *s) {
    s->top = -1;
}

// 스택 공백 검사
int is_empty(StackType *s) {
    return (s->top == -1);
}

// 스택 포화 검사
int is_full(StackType *s) {
    return (s->top == (MAX_STACK_SIZE - 1));
}

// push 함수
void push(StackType *s, element item) {
    if (is_full(s)) {
        fprintf(stderr, "스택 포화 에러\n");
        return;
    }
    s->data[++(s->top)] = item;
}

// pop 함수
element pop(StackType *s) {
    if (is_empty(s)) {
        fprintf(stderr, "스택 공백 에러\n");
        exit(1);
    }
    return s->data[(s->top)--];
}

// 괄호 검사 함수 (원인 출력 추가)
int check_matching(const char *in) {
    StackType s;
    char ch, open_ch;
    int i, n = strlen(in);
    init_stack(&s);
    int error_flag = 0;  // 오류가 발생했는지 체크

    for (i = 0; i < n; i++) {
        ch = in[i];
        switch (ch) {
            case '(':
            case '[':
            case '{':
                push(&s, ch);
                break;

                // 닫는 괄호 → pop 후 비교
            case ')':
            case ']':
            case '}':
                if (is_empty(&s)) {
                    printf("위치 %d에서 오류: 닫는 괄호 '%c'에 대응하는 여는 괄호가 없음\n", i, ch);
                    error_flag = 1;  // 오류 발생
                } else {
                    open_ch = pop(&s);
                    if ((open_ch == '(' && ch != ')') ||
                        (open_ch == '[' && ch != ']') ||
                        (open_ch == '{' && ch != '}')) {
                        printf("위치 %d에서 오류: '%c'와 '%c' 괄호가 맞지 않음\n", i, open_ch, ch);
                        error_flag = 1;  // 오류 발생
                        }
                }
                break;
        }
    }

    // 다 끝났는데 스택에 남아있으면 여는 괄호가 안 닫힘
    while (!is_empty(&s)) {
        open_ch = pop(&s);
        printf("오류: 여는 괄호 '%c'가 닫히지 않고 남아 있음\n", open_ch);
        error_flag = 1;
    }

    return (error_flag == 0); // 0이면 오류, 1이면 정상
}

int main(void) {
    char input[200];

    while (1) {
        printf("괄호식을 입력하세요 (종료하려면 exit 입력): ");
        fgets(input, sizeof(input), stdin);

        // 개행 문자 제거
        input[strcspn(input, "\n")] = '\0';

        // 종료 조건
        if (strcmp(input, "exit") == 0) break;

        // 괄호 검사 실행
        if (check_matching(input))
            printf("검사 결과: 올바른 괄호식입니다.\n");
        else
            printf("검사 결과: 잘못된 괄호식입니다.\n");

        printf("\n");
    }

    return 0;
}






