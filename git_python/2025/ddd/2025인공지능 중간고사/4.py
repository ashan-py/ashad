import random
import random
emo = 0
ch = "네"
while ch == "네":
    ok = 0
    bonus_ok = 0

    for i in range(6):
        for j in range(6):
            if lotto_list[i] == user[j]:
                ok += 1
    for k in range(6):
        if lotto_list[6] == user[k]:
            bonus_ok += 1
    if ok == 6:
        print("1등 100개임티")
        emo += 100
    elif ok == 5 and bonus_ok == 1:
        print("2등 50개 임티")
        emo += 50
    else:
        print("꽝입니다.이모티콘 10개증정")
        emo += 1