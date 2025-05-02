def cir(i):
    t1.fillcolor(color[i])
    t1.begin_fill()
    t1.circle(50)
    t1.end_fill()
    t1.penup()
    t1.left(90)
    t1.forward(100)
    t1.right(90)
    t1.pendown()

import random
import turtle
t1 = turtle.Turtle()
point = 0
color = ["red", "green", "blue"]
rsp = ["가위", "바위", "보"]
for i in range(5):

    rnum = random.randint(0,2)
    rrsp = rsp[rnum]
    print(rrsp)
    user = input("가위 바위 보")
    if (user == "가위" and rrsp == "바위") or (user == "바위" and rrsp == "보") or (user == "보" and rrsp == "가위"):
        print("졌음")
    elif (user == "가위" and rrsp == "보") or (user == "바위" and rrsp == "가위") or (user == "보" and rrsp == "바위"):
        point = point + 100
        print("이김")
    else:
        point = point + 50
        print("비김")
print(str(point)+"점")

if point >= 300:
    for i in range(3):
        cir(i)
elif point >= 200:
    for i in range(2):
        cir(i)
else:
    cir(i)

turtle.done()

