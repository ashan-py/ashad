import random
import turtle
t = turtle.Turtle()
ck = 0
for i in range(3):
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
        t.fillcolor("blue")
        t.begin_fill()
        t.circle(50)
        t.end_fill()
        ck += 1
    if ck > 0:
        t.penup()
        t.goto(0,100*ck)
        t.pendown()

turtle.done()
