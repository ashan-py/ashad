#
# use = input("놀이공원 입장권이 있으신가요?")
#
# if use == "네":
#     cm = int(input("키를 입력하시오:"))
#     if cm >= 100:
#         print("환영합니다!")
#     else:
#         print("키 더크고 오세요~")
# n = 1
# while n<100:
#     n = n+100
#     print("한번")
#
#

# print("crtl+/")


# for i in range(8):
#     i = i + 2
#     for j in range(9):
#         j = j + 1
#         print(i,"x",j,"=",i*j)
#


import random
ck = "네"
emo = 0
while ck == "네" :
    ran = random.randint(0,9)
    if 0<= ran <=3:
        ranRange = "1구간"
    elif 4<= ran <= 6:
        ranRange = "2구간"
    else:
        ranRange = "3구간"
    print(ranRange)
    user = input("난수 구간: 1구간(0~3), 2구간(4,6), 3구간(7~9)\n중 하나를 선택하시오!")
    if user == ranRange:
        print("정답")
        emo += 100

    else:
        print("실패!")

    print("현재 이모티콘 개수: ",emo)
    ck = input("다시 시작하시겠습니까?(네/아니오)")

