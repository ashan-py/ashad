#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void make_lotto_set(int n, int lotto[n][6]);
void write_lotto(int n, int lotto[n][6]);
int p_01(void) {
    int n;
    printf("로또번호 set의 수를 입력하고 Enter> ");
    scanf("%d", &n);
    int lotto[n][6];
    make_lotto_set(n,lotto);
    // for (int i = 0; i < n; i++) {
    //     for (int j = 0; j < 6; j++) {
    //         printf("%3d |",lotto[i][j]);
    //     }
    //     printf("\n");
    // }
    write_lotto(n,lotto);
    printf("출력이 완료되었습니다.");


    return 0;
}
void make_lotto_set(int n, int lotto[n][6]) {
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 6; j++) {
            int ck = 1;
            int randnum = rand() % 45 + 1;
            for (int k = 0; k < j; k++) {
                if (lotto[i][k] == randnum) {
                    ck = 0;
                }
            }
            if (ck) {
                lotto[i][j] = randnum;
            }else j--;
        }
    }

}
void write_lotto(int n, int lotto[n][6]) {
    FILE *f = fopen("lotto.txt", "w");
    for (int i = 0; i < n; i++) {
        fprintf(f, "set%3d: ", i+1);
        for (int j = 0; j < 6; j++) {
            fprintf(f, "%3d ", lotto[i][j]);
        }
        fprintf(f, "\n");
    }
    fclose(f);
}

