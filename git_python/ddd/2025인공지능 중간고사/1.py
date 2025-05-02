import random
rest = "네"
gan = ["갑", "을", "병", "정", "무","기","경","신","임","계"]
gi = ["자", "축", "인", "묘", "진", "사","오","미","신","유","술","해"]
while rest == "네":
    rannom = random.randint(1, 100)
    year = int(input("년도를 입력하시오: "))
    if rannom%2 == 0:
        gany = gan[year%10 - 4]
        giy = gi[year%12 - 4]
        print(str(gany)+str(giy)+"년")
    else:
        if (year%4 == 0 and year%100 != 0) or (year%400==0):
            print("윤년입니다.")
        else:
            print("평년")


