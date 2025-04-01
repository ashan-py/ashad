from tkinter import *

class Drastic(Frame):
    def __init__(self, root):
        super().__init__(root)
        self.width = 400
        self.height = 800

        # 전체 Canvas 생성
        self.canvas = Canvas(
            self,
            width=self.width,
            height=self.height,
            bg="white"
        )
        self.canvas.pack()

        # 맵 영역 Canvas (400x300)
        self.map_width = 400
        self.map_height = 500
        self.map_canvas = Canvas(
            self.canvas,
            width=self.map_width,
            height=self.map_height,
            bg="blue",
            highlightthickness=1,
            highlightbackground="black"
        )
        self.map_canvas.place(x=0, y=300)
        # 이미지 로드
        self.img = PhotoImage(
            file="/Users/kangbyeongjin/Desktop/me/Github/git_python/img/poke/map/test_map.png"
        )
        # 이미지를 Canvas에 추가하고, 초기 위치 설정
        self.img_id = self.canvas.create_image(0, 0, image=self.img, anchor=NW)

        # 이미지의 초기 좌표
        self.img_x = 0
        self.img_y = 0

        # 키보드 이벤트 바인딩
        root.bind("<KeyPress>", self.move_image)

        self.pack()

    def move_image(self, event):
        """키보드 입력에 따라 이미지를 움직이는 함수"""
        step = 10  # 이동 거리

        if event.keysym == "Up":
            self.img_y = self.img_y + step  # 위쪽 이동, Canvas 경계 제한
        elif event.keysym == "Down":
            self.img_y = self.img_y - step
        elif event.keysym == "Left":
            self.img_x = self.img_x + step
        elif event.keysym == "Right":
            self.img_x = self.img_x - step

        # 이미지 이동
        self.canvas.coords(self.img_id, self.img_x, self.img_y)

class trainer():

# 메인 프로그램
if __name__ == "__main__":
    window = Tk()
    window.title("Drastic Canvas with Movable Map")
    window.geometry("400x800")

    # Drastic 객체 생성
    drastic_view = Drastic(window)

    window.mainloop()