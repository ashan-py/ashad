//
// Created by 강병진 on 25. 10. 31.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int element;
typedef struct DListNode {	// 이중연결 노드 타입
    element data;
    struct DListNode *llink;
    struct DListNode *rlink;
} DListNode;

// 이중 연결 리스트를 초기화
void init(DListNode *phead)
{
    phead->llink = phead;
    phead->rlink = phead;
}

void print_reverse(DListNode* phead) {
    DListNode* p;
    printf("역순으로 출력: ");
    for (p = phead->llink; p != phead; p = p->llink) {
        printf("%d ", p->data);
    }
    printf("\n");
}
// 이중 연결 리스트의 노드를 출력
void print_dlist(DListNode *phead)
{
    DListNode* p;
    for (p = phead->rlink; p != phead; p = p->rlink) {
        printf("<-| |%d| |-> ", p->data);
    }
    printf("\n");
}
// 새로운 데이터를 노드 before의 오른쪽에 삽입한다.
void dinsert(DListNode *before, element data)
{
    DListNode *newnode = (DListNode *)malloc(sizeof(DListNode));
    newnode->data = data;
    newnode->llink = before;
    newnode->rlink = before->rlink;
    before->rlink->llink = newnode;
    before->rlink = newnode;
}
// 노드 removed를 삭제한다.
void ddelete(DListNode* head, DListNode* removed)
{
    if (removed == head) return;
    removed->llink->rlink = removed->rlink;
    removed->rlink->llink = removed->llink;
    free(removed);
}

DListNode *search(DListNode *head, element data) {
    DListNode *p = head->rlink;  // 첫 실제 노드부터 시작
    while (p != head) {          // head까지 다시 돌아오면 종료
        if (p->data == data)
            return p;            // 찾으면 해당 노드 반환
        p = p->rlink;
    }
    return NULL;  // 못 찾았을 경우
}

// 이중 연결 리스트 테스트 프로그램
int main(void)
{
    int n,t;

    DListNode* head = (DListNode *)malloc(sizeof(DListNode));
    init(head);
    printf("데이터의 개수를 입력하세요: ");
    scanf("%d",&n);
    for (int i = 0; i < n; i++) {
        // 헤드 노드의 오른쪽에 삽입
        printf("노드 #%d의 데이터를 입력하시오: ",i+1);
        scanf("%d",&t);
        dinsert(head->llink, t);
    }
    print_reverse(head);
    int f=0;
    printf("찾을 값 입력하세요: ");
    scanf("%d",&f);
    DListNode *found = search(head, f);
    if (found)
        printf("찾은 노드 데이터: %d\n", found->data);
    else
        printf("데이터를 찾을 수 없습니다.\n");
    free(head);
    return 0;
}
