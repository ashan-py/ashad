//
// Created by 강병진 on 25. 5. 12.
//
#include <stdio.h>
#include <stdlib.h>
struct node
{
    char data[10];
    struct node *link;
};
struct node* creat(void);
void input_name(struct node* ptr);
int p_18(void)
{
    struct node *head, *a1, *a2, *a3;
    a1 = creat();
    a2 = creat();
    a3 = creat();

    input_name(a1);
    input_name(a2);
    input_name(a3);

    head = a1;
    a1->link = a2;
    a2->link = a3;
    a3->link = NULL;
    printf("Linked List \n\n");
    while (head != NULL)
    {
        printf("데이터: %s, 주소: %p\n", head->data, head->link);
        head = head->link;
    }
    return 0;
}
struct node* creat(void){
    return (struct node*)malloc(sizeof(struct node));
}
void input_name(struct node* ptr) {
    printf("이름을 입력하고 Enter: ");
    scanf("%s", ptr->data);
}
