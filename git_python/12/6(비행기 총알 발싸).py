from tkinter import *  # tikinter 모듈을 불러온다.


class Sprite:
    def __init__(self, canvas, item):  # 처음 기본으로 설정할 값들을 초기값으로 준다.
        self.canvas = canvas  # 캔버스 객체
        self.item = item  # 캔버스 안에 있는 도형의 식별 번호
        self.speedy = -10  # y 방향 속도

    # 도형의 위치와 크기를 반환한다.
    def get_coords(self):
        return self.canvas.coords(self.item)


    # 객체를 움직인다.
    def move(self):
        self.canvas.move(self.item, 0, self.speedy)

    # 객체를 캔버스에서 삭제한다.
    def delete(self):
        self.canvas.delete(self.item)


class Ball(Sprite):
    def __init__(self, canvas, w,h,x, y):
        self.width = w
        self.height = h
        self.x_ = x
        self.y_ = y
        item = canvas.create_rectangle(
            x - self.width / 2,
            y - self.height / 2,
            x + self.width / 2,
            y + self.height / 2,
            fill="red",
        )
        super().__init__(canvas, item)  # 부모 클래스 생성자 호출


class Paddle(Sprite):
    def __init__(self, canvas, w, h, x, y):
        self.width = w
        self.height = h
        self.x_ = x
        self.y_ = y
        item = canvas.create_rectangle(
            x - self.width / 2,
            y - self.height / 2,
            x + self.width / 2,
            y + self.height / 2,
            fill="white",
        )
        super().__init__(canvas, item)

class Brick(Sprite):
    def __init__(self, canvas, x, y):
        self.width = 24
        self.height = 25
        item = canvas.create_rectangle(
            x - self.width / 2,
            y - self.height / 2,
            x + self.width / 2,
            y + self.height / 2,
            fill="yellow",
            tags="brick",
        )
        super().__init__(canvas, item)
        self.speedy = 5
    # 벽돌과 공이 충돌하면 벽돌을 삭제한다.
    def handle_collision(self):
        self.delete()

class BrickBreaker(Frame):
    def __init__(self, root):
        super().__init__(root)
        self.width = 300
        self.height = 480
        self.canvas = Canvas(
            self,
            bg="blue",
            width=self.width,
            height=self.height,
        )
        self.canvas.pack()
        self.pack()

        # shapes에는 화면에 있는 모든 객체가 저장된다.
        # 키는 도형 식별 번호이고 값은 객체이다.
        self.shapes = {}

        # 패들 객체를 생성하고 shapes에 저장한다.
        self.paddle = Paddle(self.canvas, 100, 20, self.width / 2, 450)
        self.shapes[self.paddle.item] = self.paddle

        # Ball 객체를 생성한다.
        self.ball = Ball(self.canvas, 10, 30, 150,450)

        # Brick 객체를 2차원 모양으로 생성한다.
        for r in range(1, 4):
            for c in range(1, 10):
                brick = Brick(self.canvas, 20 + c * 60, r * 30)
                # Brick 객체를 shapes에 저장한다.
                self.shapes[brick.item] = brick

        # 캔버스가 키보드 이벤트를 받을 수 있도록 설정한다.
        self.canvas.focus_set()
        # 마우스키와 스페이스키에 이벤트를 붙인다.
        self.canvas.bind( "<Motion>", self.motion)
        self.canvas.bind("<space>", lambda _: self.start())

    def start(self):
        self.game_loop()

    # 게임 루프를 작성한다.
    def game_loop(self):
        coords = self.ball.get_coords()  # Ball 객체의 위치를 구한다.
        # 겹치는 모든 도형을 찾는다. 식별 번호가 저장된다.
        items = self.canvas.find_overlapping(*coords)

        # 겹치는 도형의 식별 번호로 객체를 찾아서 리스트에 저장한다.
        objects = [self.shapes[x] for x in items if x in self.shapes]

        # 충돌 처리 메소드를 호출한다.
        self.collide(objects)
        self.ball.update()
        self.ball.move()

        # game_loop()를 50밀리초 후에 호출한다.
        self.after(50, self.game_loop)


    def collide(self, objects):
        x, y = self.ball.get_position()

        # 공이 앞스에 맞으면 둘다 삭제
        for obj in objects:
            if isinstance(obj, Brick):
                self.ball.delete()
                obj.handle_collision()
                w, h, x_, y_ = self.paddle.width - 2, self.paddle.height, self.paddle.x_, self.paddle.y_
                del self.shapes[self.paddle.item]
                self.paddle.delete()
                self.paddle = Paddle(self.canvas, w, h, x_, y_)
                self.shapes[self.paddle.item] = self.paddle

    def motion(self, event):
        w, h = self.paddle.width, self.paddle.height
        del self.shapes[self.paddle.item]
        x = max(event.x, w // 2)        # 마우스 포인터의 x좌표와 w를 2로 나눈 값중 큰 값을 x에 저장
        x = min(x, 640 - w // 2)
        self.paddle.delete()
        self.paddle = Paddle(self.canvas, w, h, x, 450)
        self.shapes[self.paddle.item] = self.paddle
    def gun(self):
        w, h = self.ball.width, self.paddle.height
        del self.shapes[self.paddle.item]
        self.paddle.delete()
        self.paddle = Paddle(self.canvas, w, h, x, 450)
        self.shapes[self.paddle.item] = self.paddle


window = Tk()
game = BrickBreaker(window)
window.mainloop()