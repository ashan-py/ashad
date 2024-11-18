import turtle
from turtle import *
import time
num = 0
register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pokeball.gif")
register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/jiwoo_usual.gif")
register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/jiwoo_catch.gif")
register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/obak.gif")
register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pikka.gif")
register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pielee.gif")
register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/kkobugi.gif")
register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/isanghaessi.gif")

class obk:
    def __init__(self):
        self.obak = Turtle()
        self.obak.hideturtle()
        self.obak.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/obak.gif")
        self.obak.penup()
    def pokechoose(self):
        yum = 0
        global mypoke
        global user
        self.obak.showturtle()
        userpoke = textinput("poke", "무슨 포켓몬을 고를거니?\n(피카츄, 파이리, 꼬부기, 이상해씨")
        while yum < 1:
            if userpoke == "피카츄":
                poke = pikachu()
                mypoke = poke.pika
                yum = 2
            elif userpoke== "파이리":
                poke = pielee()
                mypoke = poke.pie
                yum = 2
            elif userpoke == "꼬부기":
                poke = kkobugi()
                mypoke = poke.kkobug
                yum = 2
            elif userpoke == "이상해씨":
                poke = isanghaessi()
                mypoke = poke.isang
                yum = 2
            else:
                userpoke = textinput("poke","이런.. 그런 포켓몬은 없단다.\n(피카츄, 파이리, 꼬부기, 이상해씨)")
        self.obak.write("좋은 포켓몬을 골랐구나!")
        time.sleep(2)
        self.obak.clear()
        self.obak.hideturtle()
        user = trainer()

class trainer:
    def __init__(self):
        self.jiwoo = Turtle()
        self.jiwoo.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/jiwoo_usual.gif")
        self.jiwoo.penup()
        self.jiwoo.speed(50)

    def traingo(self):
        global num
        nu= num%2
        ball = pokeball()
        if nu == 0:
            self.jiwoo.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/jiwoo_catch.gif")
            tnx = self.jiwoo.xcor()
            tny = self.jiwoo.ycor()
            ball.open(tnx,tny)
            self.jiwoo.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/jiwoo_usual.gif")
        elif nu == 1:
            tnx = self.jiwoo.xcor()
            tny = self.jiwoo.ycor()
            ball.close(tnx, tny)
        num = num+1
class pokeball:
    def __init__(self):
        self.ball = Turtle()
        self.ball.hideturtle()
        self.ball.penup()
        self.ball.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pokeball.gif")

    def open(self,x,y):
        self.ball.goto(x,y)
        self.ball.showturtle()
        self.ball.forward(100)
        time.sleep(1)
        self.ball.hideturtle()
        bx = self.ball.xcor()
        by = self.ball.ycor()
        mypoke.goto(bx, by)
        mypoke.showturtle()
    def close(self,x,y):
        self.ball.goto(x,y)
        self.ball.showturtle()
        px = mypoke.xcor()
        py = mypoke.ycor()
        self.ball.goto(px,py)
        time.sleep(1)
        self.ball.hideturtle()
        mypoke.hideturtle()

class pikachu:
    def __init__(self):
        self.pika = Turtle()
        self.pika.hideturtle()
        self.pika.penup()
        self.pika.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pikka.gif")


class pielee:
    def __init__(self):
        self.pie = Turtle()
        self.pie.hideturtle()
        self.pie.penup()
        self.pie.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pielee.gif")

class kkobugi:
    def __init__(self):
        self.kkobug = Turtle()
        self.kkobug.hideturtle()
        self.kkobug.penup()
        self.kkobug.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/kkobugi.gif")

class isanghaessi:
    def __init__(self):
        self.isang = Turtle()
        self.isang.hideturtle()
        self.isang.penup()
        self.isang.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/isanghaessi.gif")




# →←↑↓
from tkinter import *
window = Tk()
def go(turn):
    user.jiwoo.setheading(turn)
    user.jiwoo.forward(50)
def up():
    go(90)
def down():
    go(270)
def left():
    go(180)
def right():
    go(0)
def poke():
    user.traingo()
def resett():
    o = obk()
    o.pokechoose()


b1 = Button(window, text="▲", command=up)
b2 = Button(window, text="◀", command=left)
b3 = Button(window, text="▶", command=right)
b4 = Button(window, text="▼", command=down)
b5 = Button(window, text="◉", command=poke)
b6 = Button(window, text="re", command=resett)

b1.grid(row=0, column=1)
b2.grid(row=1, column=0)
b3.grid(row=1, column=2)
b4.grid(row=2, column=1)
b5.grid(row=1, column=1)
b6.grid(row=0,column=0)


mainloop()



#### 내일
# 지우가 원하는 방향으로 이동하며 onclick
# 반경 100안에 포켓몬이 있다면 잡아라 xcor ycor
# 포켓볼 이동은 지우에서 부터 xcor ycor 해서 해당 포켓몬이 있는 위치로 goto
# 랜덤 써서 여러 종류의 포켓몬이 랜덤 생성되게함 생성 위치 또한 랜덤
