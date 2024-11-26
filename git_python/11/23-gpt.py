import os
import turtle
import random
from tkinter import *
from math import sqrt

# 윈도우 및 화면 설정
window = Tk()
window.title("포켓몬 게임")
canvas = turtle.ScrolledCanvas(window)
canvas.pack(fill="both", expand=True)

# 화면 초기화 (수정된 부분)
screen = turtle.Screen()
screen.setup(width=700, height=700)

# 이미지 경로 설정
jiwoo_usualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/human/jiwoo/jiwoo_usual.gif"
jiwoo_catchgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/human/jiwoo/jiwoo_catch.gif"
pokeballgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/ball/pokeball.gif"
pikkausualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pikkachu/pikkausual.gif"
pieleeusualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pielee/pieleeusual.gif"
kkobugiususalgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/kkobugi/kkobugiususal.gif"
isanghaessiusualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/isanghaessi/isanghaessiusual.gif"

# 이미지 등록 함수
def register_image(image_path):
    if os.path.exists(image_path):
        try:
            screen.addshape(image_path)
            print(f"등록 성공: {image_path}")
        except turtle.TurtleGraphicsError as e:
            print(f"등록 실패: {image_path} - {e}")
    else:
        print(f"오류: 경로에 파일이 없습니다 - {image_path}")

# 이미지 등록
for image in [
    jiwoo_usualgif, jiwoo_catchgif, pokeballgif,
    pikkausualgif, pieleeusualgif, kkobugiususalgif, isanghaessiusualgif
]:
    register_image(image)

# 포켓몬 클래스
class Pokemon:
    def __init__(self, name, image, x, y):
        self.name = name
        self.turtle = turtle.Turtle()
        self.turtle.shape(image)
        self.turtle.penup()
        self.turtle.goto(x, y)
        self.type = "야생"  # 기본적으로 "야생" 포켓몬

    def move_random(self):
        """포켓몬이 랜덤으로 움직이도록 함"""
        x = random.randint(-10, 10)
        y = random.randint(-10, 10)
        self.turtle.setx(self.turtle.xcor() + x)
        self.turtle.sety(self.turtle.ycor() + y)

    def catch(self):
        """포켓몬을 잡았을 때 '소유'로 바꿔주고, 포켓볼을 숨김"""
        self.type = "소유"
        self.turtle.shape(pokeballgif)  # 포켓볼로 바꾸기
        self.turtle.hideturtle()  # 포켓몬을 숨김
        print(f"{self.name} 포켓몬을 잡았습니다!")

# 지우 클래스
class Jiwoo:
    def __init__(self, image_usual, image_catch):
        self.turtle = turtle.Turtle()
        self.turtle.shape(image_usual)
        self.turtle.penup()
        self.turtle.goto(0, 0)  # 초기 위치
        self.image_catch = image_catch

    def move(self, direction):
        """지우를 이동시킬 방향을 받아 이동"""
        self.turtle.setheading(direction)
        self.turtle.forward(50)

    def catch_pokemon(self, pokemon):
        """포켓몬이 100px 이내에 있으면 포켓몬을 잡을 수 있게 함"""
        distance = self.turtle.distance(pokemon.turtle)
        if distance < 100:
            pokemon.catch()  # 포켓몬 잡기
            print(f"{pokemon.name} 포켓몬을 잡았습니다!")

# 포켓몬 생성 (랜덤 위치에 포켓몬 생성)
pokemons = []
pokemon_list = [
    {"name": "피카츄", "image": pikkausualgif},
    {"name": "파이리", "image": pieleeusualgif},
    {"name": "꼬부기", "image": kkobugiususalgif},
    {"name": "이상해씨", "image":isanghaessiusualgif}
]
# 랜덤 위치에 6마리 포켓몬 생성
for i in range(6):
    pokemon_data = random.choice(pokemon_list)
    x = random.randint(-300, 300)
    y = random.randint(-300, 300)
    pokemons.append(Pokemon(pokemon_data["name"], pokemon_data["image"], x, y))
# 지우 객체 생성
jiwoo = Jiwoo(jiwoo_usualgif, jiwoo_catchgif)

# 게임 컨트롤러
class GameController:
    def __init__(self):
        self.jiwoo = jiwoo
        self.pokemons = pokemons

    def move_up(self):
        self.jiwoo.move(90)

    def move_down(self):
        self.jiwoo.move(270)

    def move_left(self):
        self.jiwoo.move(180)

    def move_right(self):
        self.jiwoo.move(0)

    def poke(self):
        """포켓볼 던지기"""
        for pokemon in self.pokemons:
            self.jiwoo.catch_pokemon(pokemon)

    def game_loop(self):
        """게임 루프: 포켓몬 랜덤 이동 및 게임 진행"""
        for pokemon in self.pokemons:
            pokemon.move_random()
        window.after(100, self.game_loop)  # 100ms마다 계속 실행

# 버튼 정의 (조이스틱처럼 작동)
controller = GameController()

b1 = Button(window, text="▲", command=controller.move_up)
b2 = Button(window, text="◀", command=controller.move_left)
b3 = Button(window, text="▶", command=controller.move_right)
b4 = Button(window, text="▼", command=controller.move_down)
b5 = Button(window, text="◉", command=controller.poke)

# pack()을 사용하여 버튼 배치
b1.pack(side=TOP)
b2.pack(side=LEFT)
b3.pack(side=RIGHT)
b4.pack(side=BOTTOM)
b5.pack(side=BOTTOM)

# 게임 루프 시작
controller.game_loop()

# Tkinter 루프
window.mainloop()