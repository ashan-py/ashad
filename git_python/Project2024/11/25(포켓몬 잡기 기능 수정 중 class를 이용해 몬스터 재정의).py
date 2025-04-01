from turtle import *
import random
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
class monster():
    suv = 0
    monster_list = [{"name": "피카츄", "image": pikkausualgif,
                     "hp":100, "type" : "전기"},
                    {"name": "파이리", "image": pieleeusualgif,
                     "hp":100, "type" : "불"},
                    {"name": "꼬부기", "image": kkobugiususalgif,
                     "hp":100, "type" : "물"},
                    {"name": "이상해씨", "image":isanghaessiusualgif,
                     "hp":100, "type" : "풀"}
                    ]
    def __init__(self, name):
        for n in monster.monster_list:
            if n["name"] == name:
                self.name = n["name"]
                self.hp = n["hp"]
                self.type = n["type"]
                self.shape = n["image"]
        self.turtle = Turtle()
        self.turtle.penup()
        self.turtle.shape(self.shape)
    def moving(self):
        do = [0, 90, 180, 270]
        rando = random.choice(do)
        self.turtle.setheading(rando)
        self.turtle.forward(10)
pokemons = []
def survivur():
    while monster.suv<6:
        nm = (random.choice(monster.monster_list))["name"]
        rp = monster(nm)
        rp.turtle.goto(random.randint(-300,300),random.randint(-300,300))
        monster.suv = monster.suv + 1
        pokemons.append(rp)
class suvpoke():
    def __init__(self):
        self.pokemons = pokemons
    def loop(self):
        for mon in self.pokemons:
            mon.moving()
        survivur()
        ontimer(self.loop,500)

game = suvpoke()
game.loop()



mainloop()