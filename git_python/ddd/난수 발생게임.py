import random

same = 0
randnum = random.randint(1,100)
print(randnum)
while same <= 0:
    user = int(input("정수를 입력하세요: "))
    if randnum == user:
        same+=1
        print("맞춤")
    else:
        if randnum > user:
            max = randnum
            min = user
            text1 = "크게"
        else:
            max = user
            min = randnum
            text1 = "작게"

        if (max-min) >= 10:
            text2 = "매우"
        else:
            text2 = "조금"
        print(str(text2),str(text1),"하세요.")