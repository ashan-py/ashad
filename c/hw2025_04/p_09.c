// //
// // Created by 강병진 on 25. 5. 12.
// //
// #include <stdio.h>
// int p_09(void) {
//     char s[20];
//     int j;
//     unsigned uc;
//     char *kr[10] = {"공", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
//     printf("Please enter a num or nofk: ");
//     scanf("%s", s);
//     //printf("%s\n", s);
//
//     for (j = 0; j<100; j++) {
//         if (s[j] == '\0')
//             break;
//     }
//     //printf("%d\n", j);
//     char ch[100] = "" ;
//     for (int i = 0; i < j; i++) {
//         uc = s[i];
//         //printf("%d", uc);
//         if ('0' <= uc && uc <= '9') {
//             uc = uc -'0';
//             //printf("%d",uc);
//             //printf("%s", kr[uc]);
//             strcat(ch, kr[uc]);
//         }else {
//             for (int k = 0; k<j; k++) {
//                 if (strncmp(&s[i], kr[k], strlen(kr[k])) == 0) {
//                     char tmp[2];                // 임시 문자열 버퍼 (숫자 + '\0')
//                     tmp[0] = k + '0';     // 숫자 문자 하나 저장
//                     tmp[1] = '\0';
//                     strcat(ch, tmp);
//                     //printf("%dㅇㅇ", i+1);
//                     //                 // 일치하는 한글 숫자 발견
//                     //                 char digit[2] = {k + '0', '\0'};
//                     //                 strcat(output, digit);
//                     //                 i += len;  // 한글은 3바이트지만 길이로 안전하게 이동
//                     //                 matched = 1;
//                     //                 break;
//                 }
//             }
//         }
//
//     }
//     printf("%s\n", ch);
// // #include <stdio.h>
// // #include <string.h>
// //
// // int p_09(void) {
// //     char input[100];
// //     char output[100] = "";
// //     char *kr[10] = {"공", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
// //
// //     printf("한글 숫자를 입력하세요 (예: 일일일): ");
// //     scanf("%s", input);  // fgets 써도 됨
// //
// //     for (int i = 0; input[i] != '\0';) {
// //         int matched = 0;
// //         for (int k = 0; k < 10; k++) {
// //             size_t len = strlen(kr[k]);
// //             if (strncmp(&input[i], kr[k], len) == 0) {
// //                 // 일치하는 한글 숫자 발견
// //                 char digit[2] = {k + '0', '\0'};
// //                 strcat(output, digit);
// //                 i += len;  // 한글은 3바이트지만 길이로 안전하게 이동
// //                 matched = 1;
// //                 break;
// //             }
// //         }
// //         if (!matched) {
// //             printf("⚠️ 알 수 없는 문자 발견: %c\n", input[i]);
// //             break;
// //         }
// //     }
// //
// //     printf("변환 결과: %s\n", output);
// //     return 0;
//}


#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int p_09(void) {
    char s[100];
    char ch[100] = "";
    char *kr[10] = {"공", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
    char *save[100];
    printf("Please enter digits or Korean number words: ");
    scanf("%s", s);

    for (int i = 0; s[i] != '\0';) {
        unsigned char uc = s[i];

        // 숫자인 경우
        if ('0' <= uc && uc <= '9') {
            int num = uc - '0';
            strcat(ch, kr[num]);
            i++;
        }
        // 한글인 경우
        else {
            int matched = 0;
        for (int k = 0; k < 10; k++) {
            if (strncmp(&s[i], kr[k], 3) == 0) {
                char tmp[2] = {k + '0', '\0'};
                strcat(ch, tmp);
                i += 3;
                matched = 1;
                break;
            }
        }
        if (!matched) {
            printf("⚠️ 알 수 없는 문자 발견: %c\n", s[i]);
            break;
        }
        }
    }

    printf("변환 결과: %s\n", ch);
    return 0;
}