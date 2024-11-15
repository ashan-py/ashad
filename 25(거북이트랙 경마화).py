#경마게임 기능을 추가해서 소지금을 더하고 빼는 기능을 추가, 다시하기 기능 추가
import turtle
import random
t1= turtle.Turtle()
t2 = turtle.Turtle()
t3 = turtle.Turtle()
t3.speed(0)
t100 = turtle.Turtle()
def sa(x,y,go1,go2):
    t3.penup()
    t3.goto(x, y)
    t3.pendown()
    for i in range(2):
        t3.forward(go1)
        t3.left(90)
        t3.forward(go2)
        t3.left(90)

sa(-400,-200,800,400)
sa(-350,-150,700,300)
sa(-300,-100,600,200)
t3.left(180)
t3.forward(100)


m= 0
re = 1
cr = 0
usemoney = 10000


while re == 1:
    t1.reset()
    t2.reset()
    t1.shape("circle")
    t1.color("red")
    t2.shape("circle")
    t2.color("blue")
    all1 = 0
    all2 = 0
    c1 = 0
    c2 = 0
    t1.penup()
    t1.goto(-300, -125)
    t1.pendown()
    t2.penup()
    t2.goto(0, -175)
    t2.pendown()
    t100.clear()
    team = 0
    t100.write("소지금 :" + str(usemoney))
    while 1>team or team > 2:
        team = int(turtle.textinput("팀결정","빨간 거북이(1)와 파란 거북이(2) 중 이길것같은 거북이에 배팅하세요!"))
    money = int(turtle.textinput("베팅","얼마를 배팅할지 입력하세요:ex)10000"))


    while all1 <= 1750 and all2 <= 1750:
        go1 = random.randint(1, 60)
        go2 = random.randint(1, 60)
        all1 = all1 + go1
        all2 = all2 + go2

        if all1 >= 625 and c1 == 0:
            er1 = all1 - 625
            all1 = all1 - er1
            go1 = go1 - er1
            t1.forward(go1)
            c1 = c1 + 1

        elif c1 == 1 or c1 == 3 or c1 == 5:
            t1.left(90)
            c1 = c1 + 1
            t1.forward(go1)
        elif all1 >= 875 and c1 == 2:
            er1 = all1 - 875
            all1 = all1 - er1
            go1 = go1 - er1
            t1.forward(go1)
            c1 = c1 + 1
        elif all1 >= 1525 and c1 == 4:
            er1 = all1 - 1525
            all1 = all1 - er1
            go1 = go1 - er1
            t1.forward(go1)
            c1 = c1 + 1
        elif all1 >= 1750:
            er1 = all1 - 1750
            go1 = go1 - er1
            t1.forward(go1)
        else:
            t1.forward(go1)

        if all2 >= 375 and c2 == 0:
            er2 = all2 - 375
            all2 = all2 - er2
            go2 = go2 - er2
            t2.forward(go2)
            c2 = c2 + 1

        elif c2 == 1 or c2 == 3 or c2 == 5:
            t2.left(90)
            c2 = c2 + 1
            t2.forward(go2)
        elif all2 >= 725 and c2 == 2:
            er2 = all2 - 725
            all2 = all2 - er2
            go2 = go2 - er2
            t2.forward(go2)
            c2 = c2 + 1
        elif all2 >= 1475 and c2 == 4:
            er2 = all2 - 1475
            all2 = all2 - er2
            go2 = go2 - er2
            t2.forward(go2)
            c2 = c2 + 1
        elif all2 >= 1750:
            er2 = all2 - 1750
            go2 = go2 - er2
            t2.forward(go2)
        else:
            t2.forward(go2)
    t100.clear()

    if all1 > all2:
        t1.write("이겼다")
        if team == 1:
            t100.write("베팅성공!")
            usemoney = usemoney + money
        else:
            t100.write("실패!")
            usemoney = usemoney - money

    else:
        t2.write("이겼다")
        if team == 2:
            t100.write("베팅성공!")
            usemoney = usemoney + money
        else:
            t100.write("실패!")
            usemoney = usemoney - money
    re = int(turtle.textinput("리겜","게임을 다시 하시겠습니까? 네 = 1 아니오 = 0"))
    t1.clear()
    t2.clear()




turtle.done()