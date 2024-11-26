#### 목표
# 지우가 원하는 방향으로 이동
# 반경 100안에 포켓몬이 있다면 잡아라 xcor ycor
# 포켓볼 이동은 지우에서 부터 xcor ycor 해서 해당 포켓몬이 있는 위치로 goto
# 랜덤 써서 여러 종류의 포켓몬이 랜덤 생성되게함 생성 위치 또한 랜덤
import random
from turtle import *
import time
import random
line = Turtle()
line.speed(0)
line.hideturtle()
line.penup()
line.goto(-350, 350)
line.pendown()
for i in range(4):
    line.forward(700)
    line.right(90)
obakgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/human/obaksa/obak.gif"
pokeballgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/ball/pokeball.gif"
jiwoo_usualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/human/jiwoo/jiwoo_usual.gif"
jiwoo_catchgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/human/jiwoo/jiwoo_catch.gif"
pikkausualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pikkachu/pikkausual.gif"
pieleeusualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pielee/pieleeusual.gif"
kkobugiususalgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/kkobugi/kkobugiususal.gif"
isanghaessiusualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/isanghaessi/isanghaessiusual.gif"
register_shape(pokeballgif)
register_shape(jiwoo_usualgif)
register_shape(jiwoo_catchgif)
register_shape(obakgif)
register_shape(pikkausualgif)
register_shape(pieleeusualgif)
register_shape(kkobugiususalgif)
register_shape(isanghaessiusualgif)

class obk:

    def __init__(self):
        clearscreen()
        self.obak = Turtle()
        self.obak.hideturtle()
        self.obak.shape(obakgif)
        self.obak.penup()
    def pokechoose(self):
        reset()
        yum = 0
        global mypoke
        global user
        global suvpk
        self.obak.showturtle()
        userpoke = textinput("poke", "무슨 포켓몬을 고를거니?\n(피카츄, 파이리, 꼬부기, 이상해씨")
        while yum < 1:
            poke = monster()
            if userpoke == "피카츄":
                mypoke = poke.pika
                yum = 2
            elif userpoke== "파이리":
                mypoke = poke.pie
                yum = 2
            elif userpoke == "꼬부기":
                mypoke = poke.kkobug
                yum = 2
            elif userpoke == "이상해씨":
                mypoke = poke.isang
                yum = 2
            else:
                userpoke = textinput("poke","이런.. 그런 포켓몬은 없단다.\n(피카츄, 파이리, 꼬부기, 이상해씨)")
        self.obak.write("좋은 포켓몬을 골랐구나!")
        print(suvpk)
        time.sleep(2)
        self.obak.clear()
        self.obak.hideturtle()
        user = trainer()

class trainer:
    def __init__(self):
        self.jiwoo = Turtle()
        self.jiwoo.shape(jiwoo_usualgif)
        self.jiwoo.penup()
        self.jiwoo.speed(50)

    def traingo(self):
        global num
        nu= num%2
        ball = pokeball()
        if nu == 0:
            self.jiwoo.shape(jiwoo_catchgif)
            tnx = self.jiwoo.xcor()
            tny = self.jiwoo.ycor()
            ball.open(tnx,tny)
            self.jiwoo.shape(jiwoo_usualgif)
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
        self.ball.shape(pokeballgif)

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
pokeman_list = [{"name": "피카츄", "image": pikkausualgif},
    {"name": "파이리", "image": pieleeusualgif},
    {"name": "꼬부기", "image": kkobugiususalgif},
    {"name": "이상해씨", "image":isanghaessiusualgif}
                ]
class monster():
    def __init__(self,name):
        self.name = pokeman_list["name"]

        self..hideturtle()
        self.pika.penup()
        self.shape(pikkausualgif)

        self.pie = Turtle()
        self.pie.hideturtle()
        self.pie.penup()
        self.pie.shape(pieleeusualgif)

        self.kkobug = Turtle()
        self.kkobug.hideturtle()
        self.kkobug.penup()
        self.kkobug.shape(kkobugiususalgif)

        self.isang = Turtle()
        self.isang.hideturtle()
        self.isang.penup()
        self.isang.shape(isanghaessiusualgif)
    def survival(self):
        wp = random.randint(1, 4)
        if wp == 1:
            rp = "pika"
        elif wp == 2:
            rp = "pie"
        elif wp == 3:
            rp = "kkobug"
        elif wp == 4:
            rp = "isang"





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
    global suvpk
    global num
    suvpk = 0
    num = 0
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
