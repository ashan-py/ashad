# turtle은 usual 버전과 fight 버전이 존재
# tkinter은 usual 버전과 fight 버전, 오박사 상호작용 버전이 존재
# usual 버전은 turtle : 6마리의 야생 포켓몬이 랜덤 값으로 움직이고 오른쪽 상단에 오박사 존재 tkinter에는 트랙패드
# fight 버전은 turtle화면을 반틈 갈라서 내 포켓몬과 상대 포켓몬이 fight하는 공간, tkinter에는 싸우기, 가방, 도망가기, 다른 포켓몬선택 으로 바뀜
# 싸우기 : 내 포켓몬의 스킬(스킬은 최대 4개), 뒤로가기 버튼(백업을 만들어 그 전 상태 기억)
# 가방 : 포켓볼, 회복약 선택 가능, 뒤로가기 버튼
# 도망가기 : "무사히 도망쳤다. 멘트를 turtle에서 보여주며 다시 야생 창으로 변경

# 처음 오박사에게 한마리의 포켓몬을 받음
# 랜덤으로 6마리의 야생 포켓몬을 생성
# 반경 100안에 야생포켓몬이 있는 경우 상호작용 키를 누르면 배틀 시작
# 상대 포켓몬의 hp에 따라 포켓볼을 던졌을 경우 잡을 확률 높아짐 (100~80 : 10%, 79~40: 40%, : 39~30 : 60%, 29~20 : 80%, 19~10 : 90%, 9~1 : 99%)
# 포켓볼은 시작할때 10개

# 오른쪽 상단에 오박사 위치 : 상호작용 키를 누르면 (구매, 포켓몬 맡기기, 포켓몬 대려가기, 아무것도 하지 않기 버튼)으로 tkinter가 변경
# 구매하기 누르면 tkinter가 포켓볼, 회복약 뒤로가기 버튼으로 바뀜
# 포켓몬 맡기기를 내가 소지하고 있는 포켓몬을 알려주며 textinput을 이용해 그 포켓몬을 소지 -> pc 로 이동, 취소를 입력하면 창 나가기
# 포켓몬 대려가기를 누르면 내 pc에 있는 포켓몬을 알려주며 textinput을 통해 그 포켓몬을 pc-> 소지 로 이동, 취소를 입력하면 창 나가기
# 아무것도 하지 않기를 누르면 tkinter가 usual로 변경
from turtle import *
import random
import time

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

# class obk:
#
# class trainer:

class monster():
    suv = []
    userpk = []
    monster_list = [{"name": "피카츄", "image": pikkausualgif,
                     "hp": 100, "type": "전기"},
                    {"name": "파이리", "image": pieleeusualgif,
                     "hp": 100, "type": "불"},
                    {"name": "꼬부기", "image": kkobugiususalgif,
                     "hp": 100, "type": "물"},
                    {"name": "이상해씨", "image": isanghaessiusualgif,
                     "hp": 100, "type": "풀"}
                    ]
    def create(self,name):
        for n in monster.monster_list:
            if n["name"] == name:
                self.name = n["name"]
                self.hp = n["hp"]
                self.type = n["type"]
                self.shape = n["image"]
        self.turtle = Turtle()
        self.turtle.hideturtle()
        self.turtle.penup()
        self.turtle.shape(self.shape)
    def survivur(self):
        while len(self.suv) < 6:
            nm = (random.choice(self.monster_list))["name"]
            rp = monster()
            rp.create(nm)
            rp.turtle.goto(random.randint(-300, 300), random.randint(-300, 300))
            rp.turtle.showturtle()
            self.suv.append(rp)
            self.move(rp)

    def move(self,nn):
        do = [0, 90, 180, 270]
        rando = random.choice(do)
        nn.turtle.setheading(rando)
        nn.turtle.forward(10)
        ontimer(lambda: self.move(nn), 1000)


mon = monster()
mon.survivur()
mainloop()