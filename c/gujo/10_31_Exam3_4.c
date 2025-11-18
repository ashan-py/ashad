//
// Created by 강병진 on 25. 10. 31.
//


#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct ListNode { 	// 노드 타입
	element data;
	struct ListNode *link;
} ListNode;
// 리스트의 항목 출력


ListNode* insert_last(ListNode* head, element data)
{
	ListNode *node = (ListNode *)malloc(sizeof(ListNode));
	node->data = data;
	if (head == NULL) {
		head = node;
		node->link = head;
	}
	else {
		node->link = head->link;	// (1)
		head->link = node;		// (2)
		head = node;		// (3)
	}
	return head;	// 변경된 헤드 포인터를 반환한다.
}


ListNode *search(ListNode *L, element data) {

	if (L == NULL) {
		printf("error");
		return NULL;
	}
	ListNode* p = L->link;

	do {
		if (p->data == data)
			return p;
		p = p->link;
	} while (p != L->link);
	return NULL;

}

int get_size(ListNode *L) {
	int sum = 0;
	if (L == NULL) {
		printf("error");
		return 0;
	}
	ListNode* p = L->link;
	do {
		sum++;
		p = p->link;
	} while (p != L->link);

	return sum;
}


int main(void)
{
	ListNode *head = NULL;

	// list = 10->20->30->40
	head = insert_last(head, 10);
	head = insert_last(head, 20);
	head = insert_last(head, 30);
	head = insert_last(head, 40);

	int s = search(head,40)->data;
	if (s) {
		printf("serch함수로 찾기: %d 있음\n",search(head, 40)->data);
	}
	printf("get_size 찾은 함수로 데이터 개수: %d\n",get_size(head));


	free(head);
	return 0;
}
