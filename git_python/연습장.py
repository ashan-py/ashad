# #이미지 파일 사이즈 조절
#
# from PIL import Image
#
# # 고양이 이미지 불러와서 img라는 변수에 입력
# img = Image.open('/Users/kangbyeongjin/Desktop/Pasted Graphic 4.png')
# img_resized = img.resize((60,27))
# img_resized.save("/Users/kangbyeongjin/Desktop/resized_image.png")
# # 변경한 이미지 출력
# img_resized.show()
#
# # 비교를 위해 원본 이미지 출력
# img.show()

# -------------------------------------------------------------

# from turtle import *
#
# # 이미지 등록 (이름을 명시적으로 지정)
# register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pokeball.gif")
#
# class Car:
#     def __init__(self, speed, color, model):
#         self.speed = speed
#         self.color = color
#         self.model = model
#         self.t1 = Turtle()
#         self.t1.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pokeball.gif")  # 등록된 이름 "car" 사용
#
#     def drive(self):
#         self.t1.forward(self.speed)
#
#     def left_turn(self):
#         self.t1.left(90)
#
#
# # 자동차 객체 생성
# myCar = Car(200, "red", "E-class")
#
# # 자동차 이동
# for i in range(100):
#     myCar.drive()
#     myCar.left_turn()
#
# mainloop()
#
#
#
# from turtle import *
# import random
#
# register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pikkachu/pikkausual.gif")
# register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pielee/pieleeusual.gif")
# register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/kkobugi/kkobugiususal.gif")
# register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/isanghaessi/isanghaessiusual.gif")
# class Monster:
#     def __init__(self):
#         # 포켓몬 객체를 딕셔너리에 저장 (이름과 함께)
#         self.pokemons = {
#             "pika": self.create_turtle("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pikkachu/pikkausual.gif"),
#             "pie": self.create_turtle("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pielee/pieleeusual.gif"),
#             "kkobug": self.create_turtle("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/kkobugi/kkobugiususal.gif"),
#             "isang": self.create_turtle("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/isanghaessi/isanghaessiusual.gif")
#         }
#
#     def create_turtle(self, shape_path):
#         """새로운 Turtle 객체를 생성하고 설정"""
#         t = Turtle()
#
#         t.penup()
#         t.shape(shape_path)  # 주어진 모양 적용
#         t.speed(1)
#         t.forward(100)
#         return t
#     p = 0
#
#     def survival(self):
#         """랜덤으로 하나의 포켓몬을 선택"""
#         # 딕셔너리의 키 리스트에서 랜덤 선택
#         random_name = random.choice(list(self.pokemons.keys()))  # 포켓몬 이름만 선택
#         random_name_with_p = random_name + str(self.p)  # 이름 + p값 (이 값을 화면에 표시)
#         self.p += 1  # p 값 증가
#         selected_pokemon = self.pokemons[random_name]  # 선택된 포켓몬 객체 가져오기
#         print(f"Selected Pokemon: {random_name_with_p}")  # 선택된 포켓몬 이름 출력
#
#         return selected_pokemon
# mon = Monster()
# mon.survival()
#
# for i in range(30):
#     mon.survival()
# t1 = mon.pokemons["pika"]
# t1.showturtle()
# t1.goto(0,100)
# print
# t2 = mon.pokemons["pika"]
# t2.showturtle()
# t2.forward(100)
#
# print(1)
# mainloop()

# class Car:
#     def __init__(self, speed, color, model):
#         self.speed = speed
#         self.color = color
#         self.model = model
#
#     def drive(self):
#         self.speed = 60
#     def __str__(self):
#         msg = "속도:" + str(self.speed) + " 색상:" + self.color + " 모델:" + self.model
#         return msg
#
#
# dadCar = Car(0, "silver", "A6")
# momCar = Car(0, "white", "520d")
# myCar = Car(0, "blue", "E-class")
# print(dadCar)
# print(momCar)
# print(myCar)
#
# from turtle import *
# import random
# obakgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/human/obaksa/obak.gif"
# pokeballgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/ball/pokeball.gif"
# jiwoo_usualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/human/jiwoo/jiwoo_usual.gif"
# jiwoo_catchgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/human/jiwoo/jiwoo_catch.gif"
# pikkausualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pikkachu/pikkausual.gif"
# pieleeusualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/pielee/pieleeusual.gif"
# kkobugiususalgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/kkobugi/kkobugiususal.gif"
# isanghaessiusualgif = "/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/monster/isanghaessi/isanghaessiusual.gif"
# register_shape(pokeballgif)
# register_shape(jiwoo_usualgif)
# register_shape(jiwoo_catchgif)
# register_shape(obakgif)
# register_shape(pikkausualgif)
# register_shape(pieleeusualgif)
# register_shape(kkobugiususalgif)
# register_shape(isanghaessiusualgif)
# class monster():
#     suv = 0
#     monster_list = [{"name": "피카츄", "image": pikkausualgif,
#                      "hp":100, "type" : "전기"},
#                     {"name": "파이리", "image": pieleeusualgif,
#                      "hp":100, "type" : "불"},
#                     {"name": "꼬부기", "image": kkobugiususalgif,
#                      "hp":100, "type" : "물"},
#                     {"name": "이상해씨", "image":isanghaessiusualgif,
#                      "hp":100, "type" : "풀"}
#                     ]
#     def __init__(self, name):
#         for n in monster.monster_list:
#             if n["name"] == name:
#                 self.name = n["name"]
#                 self.hp = n["hp"]
#                 self.type = n["type"]
#                 self.shape = n["image"]
#         self.turtle = Turtle()
#         self.turtle.penup()
#         self.turtle.shape(self.shape)
#     def moving(self):
#         do = [0, 90, 180, 270]
#         rando = random.choice(do)
#         self.turtle.setheading(rando)
#         self.turtle.forward(10)
# pokemons = []
# def survivur():
#     while monster.suv<6:
#         nm = (random.choice(monster.monster_list))["name"]
#         rp = monster(nm)
#         rp.turtle.goto(random.randint(-300,300),random.randint(-300,300))
#         monster.suv = monster.suv + 1
#         pokemons.append(rp)
# class suvpoke():
#     def __init__(self):
#         self.pokemons = pokemons
#     def loop(self):
#         for mon in self.pokemons:
#             mon.moving()
#         survivur()
#         ontimer(self.loop,500)
#
# game = suvpoke()
# game.loop()
#
#
#
# mainloop()
#
#
# class monster():
#     suv = []
#     userpk = []
#     monster_list = [{"name": "피카츄", "image": pikkausualgif,
#                      "hp": 100, "type": "전기"},
#                     {"name": "파이리", "image": pieleeusualgif,
#                      "hp": 100, "type": "불"},
#                     {"name": "꼬부기", "image": kkobugiususalgif,
#                      "hp": 100, "type": "물"},
#                     {"name": "이상해씨", "image": isanghaessiusualgif,
#                      "hp": 100, "type": "풀"}
#                     ]
#     def create(self, name):
#         for n in monster.monster_list:
#             if n["name"] == name:
#                 self.name = n["name"]
#                 self.hp = n["hp"]
#                 self.type = n["type"]
#                 self.shape = n["image"]
#         self.turtle = Turtle()
#         self.turtle.penup()
#         self.turtle.shape(self.shape)
#
#     def survivur(self):
#         while len(self.suv) < 6:
#             nm = (random.choice(self.monster_list))["name"]
#             rp = monster()  # 새로운 monster 인스턴스를 생성
#             rp.create(nm)  # 'create' 메서드에서 포켓몬 이름을 전달
#             rp.turtle.goto(random.randint(-300, 300), random.randint(-300, 300))
#             self.suv.append(rp)
#             self.loop(rp.turtle)
#             print(self.suv)
#         ontimer(lambda: self.survivur,1000)
#     def loop(self,tur):
#         do = [0, 90, 180, 270]
#         rando = random.choice(do)
#         tur.setheading(rando)
#         tur.forward(10)
#         ontimer(lambda: self.loop(tur), 1000)
#
#
#
#
#
# mon = monster()
# mon.survivur()  # 'survivur' 메서드를 호출
#
# mainloop()


import random
from tkinter import *

class Sprite:
    def __init__(self, canvas, item):
        self.canvas = canvas
        self.item = item
        self.speedx = 0
        self.speedy = 0

    def get_coords(self):
        return self.canvas.coords(self.item)

    def move(self):
        self.canvas.move(self.item, self.speedx, self.speedy)

    def delete(self):
        self.canvas.delete(self.item)

class Bullet(Sprite):
    def __init__(self, canvas, x, y):
        self.width = 10
        self.height = 30
        item = canvas.create_rectangle(
            x - self.width / 2,
            y - self.height,
            x + self.width / 2,
            y,
            fill="red",
        )
        super().__init__(canvas, item)
        self.speedy = -10

class Plane(Sprite):
    def __init__(self, canvas, w, h, x, y):
        self.width = w
        self.height = h
        item = canvas.create_rectangle(
            x - self.width / 2,
            y - self.height / 2,
            x + self.width / 2,
            y + self.height / 2,
            fill="blue",
        )
        super().__init__(canvas, item)

class Enemy(Sprite):
    def __init__(self, canvas, x, y):
        self.width = 40
        self.height = 40
        item = canvas.create_rectangle(
            x - self.width / 2,
            y - self.height / 2,
            x + self.width / 2,
            y + self.height / 2,
            fill="yellow",
        )
        super().__init__(canvas, item)
        self.speedy = 5

class ShootingGame(Frame):
    def __init__(self, root):
        super().__init__(root)
        self.width = 300
        self.height = 480
        self.canvas = Canvas(
            self,
            bg="black",
            width=self.width,
            height=self.height,
        )
        self.canvas.pack()
        self.pack()

        self.shapes = {}

        # Plane 생성
        self.plane = Plane(self.canvas, 50, 20, self.width / 2, self.height - 50)
        self.shapes[self.plane.item] = self.plane

        # 이벤트 바인딩
        self.canvas.focus_set()
        self.canvas.bind("<Motion>", self.move_plane)

        # 총알과 적 관리를 위한 리스트
        self.bullets = []
        self.enemies = []

        # 반복 실행 설정
        self.spawn_enemy()
        self.shoot_bullet()
        self.update_game()

    def move_plane(self, event):
        x = max(event.x, self.plane.width / 2)
        x = min(x, self.width - self.plane.width / 2)
        self.plane.canvas.coords(
            self.plane.item,
            x - self.plane.width / 2,
            self.height - 70,
            x + self.plane.width / 2,
            self.height - 50,
        )

    def shoot_bullet(self):
        x, y = self.plane.get_coords()[:2]
        bullet = Bullet(self.canvas, x + self.plane.width / 2, y)
        self.bullets.append(bullet)
        self.shapes[bullet.item] = bullet
        self.after(1000, self.shoot_bullet)

    def spawn_enemy(self):
        x = random.randint(20, self.width - 20)
        enemy = Enemy(self.canvas, x, 20)
        self.enemies.append(enemy)
        self.shapes[enemy.item] = enemy
        self.after(2000, self.spawn_enemy)

    def update_game(self):
        for bullet in self.bullets[:]:
            bullet.move()
            if bullet.get_coords()[1] < 0:
                bullet.delete()
                self.bullets.remove(bullet)

        for enemy in self.enemies[:]:
            enemy.move()
            if enemy.get_coords()[3] > self.height:
                enemy.delete()
                self.enemies.remove(enemy)

        # 충돌 체크
        for bullet in self.bullets[:]:
            for enemy in self.enemies[:]:
                if self.check_collision(bullet, enemy):
                    bullet.delete()
                    enemy.delete()
                    self.bullets.remove(bullet)
                    self.enemies.remove(enemy)
                    break

        self.after(50, self.update_game)

    def check_collision(self, sprite1, sprite2):
        x1, y1, x2, y2 = sprite1.get_coords()
        a1, b1, a2, b2 = sprite2.get_coords()
        return not (x2 < a1 or x1 > a2 or y2 < b1 or y1 > b2)

window = Tk()
game = ShootingGame(window)
window.mainloop()