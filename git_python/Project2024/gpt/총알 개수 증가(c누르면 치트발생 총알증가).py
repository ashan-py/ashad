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

        # 초기 변수
        self.level = 1
        self.experience = 0
        self.exp_to_next_level = 10
        self.bullets_per_shot = 1

        # HUD 표시
        self.hud = self.canvas.create_text(
            10, 10, anchor="nw", fill="white", font=("Arial", 14),
            text=self.get_hud_text()
        )

        # Plane 생성
        self.plane = Plane(self.canvas, 50, 20, self.width / 2, self.height - 50)

        # 이벤트 바인딩
        self.canvas.focus_set()
        self.canvas.bind("<Motion>", self.move_plane)
        self.canvas.bind("<KeyPress-c>", self.cheat)  # 'c' 버튼을 눌렀을 때 호출

        # 총알과 적 관리를 위한 리스트
        self.bullets = []
        self.enemies = []

        # 반복 실행 설정
        self.spawn_enemy()
        self.shoot_bullet()
        self.update_game()

    def get_hud_text(self):
        return f"Level: {self.level}  EXP: {self.experience}/{self.exp_to_next_level}  Bullets: {self.bullets_per_shot}"

    def update_hud(self):
        self.canvas.itemconfig(self.hud, text=self.get_hud_text())

    def level_up(self):
        self.level += 1
        self.experience = 0
        self.exp_to_next_level += 10
        self.bullets_per_shot += 1
        self.update_hud()

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
        plane_coords = self.plane.get_coords()
        plane_center_x = (plane_coords[0] + plane_coords[2]) / 2
        plane_center_y = plane_coords[1]

        # 여러 개의 총알을 대칭적으로 발사
        spacing = 15  # 총알 간격
        offset_start = -(self.bullets_per_shot - 1) / 2 * spacing
        for i in range(self.bullets_per_shot):
            offset = offset_start + i * spacing
            bullet = Bullet(self.canvas, plane_center_x + offset, plane_center_y)
            self.bullets.append(bullet)
        self.after(1000, self.shoot_bullet)

    def spawn_enemy(self):
        x = random.randint(20, self.width - 20)
        enemy = Enemy(self.canvas, x, 20)
        self.enemies.append(enemy)
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
                    self.gain_experience(1)
                    break

        self.after(50, self.update_game)

    def check_collision(self, sprite1, sprite2):
        x1, y1, x2, y2 = sprite1.get_coords()
        a1, b1, a2, b2 = sprite2.get_coords()
        return not (x2 < a1 or x1 > a2 or y2 < b1 or y1 > b2)

    def gain_experience(self, amount):
        self.experience += amount
        if self.experience >= self.exp_to_next_level:
            self.level_up()
        self.update_hud()

    def cheat(self, event):
        # 'c' 키를 눌렀을 때 총알을 1개 추가
        self.bullets_per_shot += 1
        self.update_hud()

window = Tk()
game = ShootingGame(window)
window.mainloop()