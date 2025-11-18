// // #include <stdio.h>
// // void hanoi_tower(int n, char from, char tmp, char to) {
// //     if (n == 1) printf("원판 1을 %c 에서 %c로 옮긴다.\n", from, to);
// //     else {
// //         hanoi_tower(n - 1, from, to,tmp);
// //         printf("원판 %d을 %c에서 %c으로 옮긴다.\n",n,from, to);
// //         hanoi_tower(n - 1, tmp, from, to);
// //     }
// // }
// //
// // int main(void) {
// //     hanoi_tower(4,'A','B','C');
// //     return 0;
// // }
//
//
// // #include <stdio.h>
// //
// // void unkown() {
// //     int ch;
// //     if ((ch=getchar()) !='\n')
// //         unkown();
// //     putchar(ch);
// // }
// // int main() {
// //     unkown();
// // }
//
// //
// // #include <stdio.h>
// //
// // double div(int n) {
// //     if(n==1) return 1;
// //     else return (double)1/n + div(n-1);
// // }
// // int main() {
// //     printf("%f",div(5));
// // }
//
// // typedef struct pointTag {
// //     int x;
// //     int y;
// //
// // }Point;
//
//
// #include <stdio.h>
//
// void insert(int array[], int n,int items, int loc, int value){
//
//     for (int i = items; i>=loc; i--){
//         array[i+1] = array[i];
//
//
//     }
//     array[loc] = value;
// }
// int main() {
//     int n = 10;
//     int array[10] = {1, 2, 3, 4, 5, 6};
//     insert(array, n, 6, 3, 8);
//     for (int i = 0; i < 7; i++) {
//         printf("%d ", array[i]);
//     }
// }

#include <stdio.h>
#include <stdlib.h>

// 노드 구조체 정의
typedef struct ListNode {
    int data;
    struct ListNode *link;
} ListNode;

// insert_node 함수
ListNode *insert_node(ListNode *L, ListNode *before, ListNode *new) {
    ListNode *p = before->link;  // before 다음 노드를 임시로 저장
    before->link = new;          // before가 new를 가리키게 함
    new->link = p;               // new가 원래 before 다음 노드를 가리키게 함
    return L;                    // 리스트의 시작 주소 그대로 반환
}

// 리스트 출력 함수
void print_list(ListNode *L) {
    ListNode *p = L;
    while (p != NULL) {
        printf("%d -> ", p->data);
        p = p->link;
    }
    printf("NULL\n");
}

int main() {
    // 노드 3개 동적 생성
    ListNode *n1 = (ListNode*)malloc(sizeof(ListNode));
    ListNode *n2 = (ListNode*)malloc(sizeof(ListNode));
    ListNode *n3 = (ListNode*)malloc(sizeof(ListNode));

    // 데이터 입력
    n1->data = 10; n1->link = n2;
    n2->data = 20; n2->link = n3;
    n3->data = 30; n3->link = NULL;

    // 리스트 헤드 설정
    ListNode *head = n1;

    printf("삽입 전 리스트:\n");
    print_list(head);

    // 새 노드 생성
    ListNode *newNode = (ListNode*)malloc(sizeof(ListNode));
    newNode->data = 99;

    // n1(10) 뒤에 newNode 삽입
    head = insert_node(head, n1, newNode);

    printf("\n삽입 후 리스트:\n");
    print_list(head);

    // 메모리 해제 (테스트용으로 생략해도 무방)
    free(n1); free(n2); free(n3); free(newNode);

    return 0;
}