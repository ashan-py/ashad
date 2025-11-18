#include <stdio.h>
#include <string.h>

int p_10(void) {
    char amount[100]={};
    int ret[100] = {};
    char *kr[10] = {"공", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
    char *fst[] = {"십","백","천","만","억"};
    //{"십억"}
    int retl;
    char str[100] = "";

    printf("Please enter a number: ");
    scanf("%s", &amount);
    //printf("%s", amount);

    for (int i = 0; amount[i] != '\0';) {
        unsigned char uc = amount[i];
        if ('0' <= uc && uc <= '9') {
            int num = uc - '0';
            ret[i] = num;
            i++;
        }
        retl = i;
    }
    // printf("%dadsfs%d",ret[0],ret[1]);
    for (int i = 0; retl >=i; i++) {
        if (ret[i] !=0) {
            strcat(str, kr[ret[i]]);
            if ((retl-i) !=1 &&(retl-i-2)%4 == 0) {
                strcat(str, fst[0]);
            }else if ((retl-i-3)%4 == 0) {
                strcat(str, fst[1]);
            }else if ((retl-i-4)%4 == 0) {
                strcat(str, fst[2]);
            }



        }
        if ((retl-i) ==9) {
            strcat(str, fst[4]);
        }else if ((retl-i) ==5) {
            strcat(str, fst[3]);
        }

    }
    //if (strlen(ret))
    printf("%s", str);
}
