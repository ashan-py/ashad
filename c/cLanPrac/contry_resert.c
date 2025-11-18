//
// Created by 강병진 on 25. 6. 15.
//

#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#define FILE_NAME "game_results.bin"
struct contry {
    char name[13];
    int win;
    int lose;
    int draw;
};
void resert_all();
void resert_select();
void resert_edit();
void select_menu();

int main(void) {

    // struct contry resert[4] = {
    //     {"korea",1,1,1},
    //     {"USA",1,1,1},
    //     {"poland",1,1,1},
    //     {"japan",1,1,1}
    // };
    // FILE *fp;
    // fp = fopen(FILE_NAME, "wb");
    // fwrite(resert, sizeof(struct contry), 4, fp);
    // fclose(fp);
    select_menu();

}
void resert_all() {
    int block;

    FILE *fr;
    fr = fopen(FILE_NAME, "rb");

    fseek(fr, 0L,2);
    block = ftell(fr)/sizeof(struct contry);

    struct contry resert[block];

    fseek(fr, 0L,0);
    fread(resert, sizeof(struct contry), block, fr);
    fclose(fr);

    for (int i = 0; i<block; i++) {
        printf("%-8s %2d %2d %2d \n",resert[i].name,resert[i].win,resert[i].lose,resert[i].draw);
    }
    select_menu();
}

void resert_select() {
    int block;
    char user_c[100];
    FILE *fr;
    fr = fopen(FILE_NAME,"rb");

    fseek(fr, 0L,2);
    block = ftell(fr)/sizeof(struct contry);

    struct contry resert[block];

    fseek(fr,0L,0);
    fread(resert, sizeof(struct contry), block, fr);
    fclose(fr);

    printf("어느 나라의 데이터를 확인하시겠습니까?( ");
    for (int i = 0; i < block; i++) {
        printf("%s ",resert[i].name);
    }
    printf(")\n");
    scanf("%s", user_c);
    int ck = -1;

    for (int i = 0; i<block; i++) {
        if (strcmp(user_c, resert[i].name)==0)
            ck = i;
    }
    if (ck==-1) {
        printf("그 이름을 가진 나라의 데이터는 저장되어있지 않습니다.\n");

    }else {
        printf("%-8s %2d %2d %2d\n",resert[ck].name, resert[ck].win,resert[ck].lose,resert[ck].draw);
    }

    select_menu();
}

void resert_edit() {
    int block;
    char user_c[100];
    FILE *fr;
    fr = fopen(FILE_NAME,"rb+");

    fseek(fr,0L,2);
    block = ftell(fr)/sizeof(struct contry);

    struct contry resert[block];
    fseek(fr,0L,0);
    fread(resert, sizeof(struct contry),block,fr);

    for (int i = 0; i<block; i++) {
        printf("%-8s %2d %2d %2d\n",resert[i].name,resert[i].win,resert[i].lose,resert[i].draw);
    }
    printf("에서 수정하실 나라 이름을 입력해주세요.\n>>");
    scanf("%s",user_c);
    int ck = -1;
    for (int i = 0; i<block; i++) {
        if (strcmp(user_c, resert[i].name) == 0) {
            ck = i;
        }
    }
    if (ck==-1) {
        printf("그런 나라는 없습니다.");
    }else {

        printf("승 패 무 순으로 수정하실 점수를 입력해주세요.\n>>");
        scanf("%d %d %d",&resert[ck].win,&resert[ck].lose,&resert[ck].draw);
        //getchar();
        printf("%-8s %2d %2d %2d 로 수정되었습니다.\n",resert[ck].name,resert[ck].win,resert[ck].lose,resert[ck].draw);
        printf("파일에 덮어쓰시겠습니까?(yes or no)\n>>");
        scanf("%s",&user_c);

        if (strcmp(user_c, "yes")==0) {
            fseek(fr,0L,0);
            fseek(fr, ck*sizeof(struct contry),0);
            fwrite(&resert[ck], sizeof(struct contry), 1, fr);

            fseek(fr,0L,0);
            fread(resert, sizeof(struct contry),block,fr);

            for (int i = 0; i<block; i++) {
                printf("%-8s %2d %2d %2d\n",resert[i].name,resert[i].win,resert[i].lose,resert[i].draw);

            }
            printf("위와 같이 수정되었습니다.\n");

        }
    }
    fclose(fr);



    select_menu();
}
void select_menu() {
    int userc;
    while (1) {
        printf("어떤 작업을 하시겠습니까?\n1.전체 결과 확인\n2.특정 나라 결과확인\n3.결과 수정\n4.그만하기\n>>");
        scanf("%d",&userc);
        if (userc == 1) {
            resert_all();
            break;
        }
        if (userc == 2) {
            resert_select();
            break;
        }
        if (userc ==3) {
            resert_edit();
            break;
        }
        if (userc == 4) {
            printf("종료되었습니다.");
            exit(0);
        }

        printf("올바른 값을 입력하세요.\n");
        getchar();

    }
}