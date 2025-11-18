// //
// // Created by 강병진 on 25. 10. 27.
//
#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct ListNode {
    element data;
    struct ListNode *link;
}ListNode;

typedef struct ListType {
    int size;
    ListNode *head;
    ListNode *tail;
}ListType;

ListType* create() {
    ListType *plist = (ListType *)malloc(sizeof(ListType));
    plist->size = 0;
    plist->head = plist-> tail = NULL;
    return plist;
}

void insert_last(ListType* plist, int data) {
    ListNode *p = (ListNode *)malloc(sizeof(ListNode));
    p-> data = data;
    p->link = NULL;
    if (plist-> tail == NULL) {
        plist->head = plist->tail = p;
    }
    else {
        plist->tail->link = p;
        plist->tail = p;
    }
    plist->size++;
}
void t_print(ListType* plist) {
    ListNode *p = plist->head;

    printf("생성된 연결 리스트: ");
    for (;p;p=p->link) {
        if (p->link)
            printf("%d->", p->data);
        else
            printf("%d", p->data);
    }
    printf("\n");
}

void count_nodes(ListType* plist) {
    printf("연결 리스트 노드의 개수 = %d\n",plist->size);
}

int sum_nodes_value(ListType* plist) {
    ListNode *p = plist->head;
    int sum = 0;
    for (;p;p=p->link) {
        sum += p->data;
    }

    printf("연결 리스트의 데이터 합: %d\n",sum);
    return sum;
}

int check_nodes_value(ListType* plist) {
    int ch=0;
    int sum=0;
    printf("탐색할 값을 입력하시오: ");
    scanf("%d",&ch);
    ListNode *p = plist->head;
    for (;p;p=p->link) {
        if (p-> data == ch) sum++;
    }
    printf("%d는 연결 리스트에서 %d번 나타납니다.",ch,sum);
    return sum;
}

int nodes_value_delete(ListType* plist) {
    int ch=0;
    printf("삭제할 값을 입력하시오: ");
    scanf("%d",&ch);
    ListNode *p = plist->head;
    for (;p;p=p->link) {
        if (p-> data == ch) {

        }
    }
    printf("%d는 연결 리스트에서 %d번 나타납니다.",ch,sum);
    return sum;
}

int main() {
    ListType *head = create();
    int n, t;
    printf("노드의 개수 : ");
    scanf("%d",&n);
    for (int i = 1; i <= n; i++) {
        printf("노드 #%d 데이터 : ",i);
        scanf("%d",&t);
        insert_last(head,t);

    }
    t_print(head);

    count_nodes(head);

    sum_nodes_value(head);

    check_nodes_value(head);

    free(head);
    return 0;
}


//#include <stdio.h>

// void insert(int array[],  int loc, int value) {
//     int items = 8;
//     for (int i = items; i>=loc ; i--) {
//         array[i] = array[i-1];
//     }
//     array[loc] = value;
//     for (int f = 0; f<9;f++){
//        printf("%d",array[f]);
//     }
// }
//
// int main() {
//     int array[10] = {0,1,2,3,4,5,6,7};
//     insert(array, 6, 4);
// }
