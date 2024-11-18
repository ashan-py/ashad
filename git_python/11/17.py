from turtle import *

register_shape("pkb","/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pokeball.gif")
register_shape("jiwoousual","/Users/kangbyeongjin/Desktop/me/Github/git_python/img/jiwoo_usual.gif")
register_shape("jiwoocatch","/Users/kangbyeongjin/Desktop/me/Github/git_python/img/jiwoo_usual.gif")
register_shape("obaksa", "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/obak.gif")

class obk:
    def __init__(self):
        self.obak = Turtle()
        self.obak.hideturtle()
        self.obak.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/obak.gif")
        self.obak.penup()
    def pokechoose(self):
        userpoke = textinput("무슨 포켓몬을 고를거니?\n(피카츄, 파이리, 꼬부기, 이상해씨")
        self.obak.showturtle()
        if userpoke == "피카츄":


        self.obak.write("좋은 포켓몬을 골랐구나!")

class trainer:
    def __init__(self):
        self.jiwoo = Turtle()
        self.jiwoo.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/jiwoo_usual.gif")
        self.jiwoo.penup()
        self.jiwoo.speed(50)

    def traingo(self):
        self.jiwoo.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/jiwoo_usual.gif")
        tnx = self.jiwoo.xcor()
        tny = self.jiwoo.ycor()
        pokeball.open(tnx,tny)




class pokeball:
    def __init__(self):
        self.ball = Turtle()
        self.ball.hideturtle()
        self.ball.penup()
        self.ball.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pokeball.gif")

    def trainingpoke(self):

    def open(self,x,y):
        self.ball.goto(x,y)
        self.ball.forward(100)

class pikachu:


class pielee:
    def __init__(self):
        self.pielee = Turtle()

        self.pielee.penup()
        self.pielee.goto(-150,100)
class kkobugi:



ball = pokeball()
pielee.hideturtle()
pielee.

# →←↑↓
from tkinter import *
window = Tk()
def go(turn):
    user = trainer()
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
    trainer.traingo()
b1 = Button(window, text="▲", command=up)
b2 = Button(window, text="◀", command=left)
b3 = Button(window, text="▶", command=right)
b4 = Button(window, text="▼", command=down)
b5 = Button(window, text="◉")
b1.grid(row=0, column=1)
b2.grid(row=1, column=0)
b3.grid(row=1, column=2)
b4.grid(row=2, column=1)
b5.grid(row=1, column=1)


mainloop()



#### 내일
# 지우가 원하는 방향으로 이동하며 onclick
# 반경 100안에 포켓몬이 있다면 잡아라 xcor ycor
# 포켓볼 이동은 지우에서 부터 xcor ycor 해서 해당 포켓몬이 있는 위치로 goto
# 랜덤 써서 여러 종류의 포켓몬이 랜덤 생성되게함 생성 위치 또한 랜덤
