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

from turtle import *

# 이미지 등록 (이름을 명시적으로 지정)
register_shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pokeball.gif")

class Car:
    def __init__(self, speed, color, model):
        self.speed = speed
        self.color = color
        self.model = model
        self.t1 = Turtle()
        self.t1.shape("/Users/kangbyeongjin/Desktop/me/Github/git_python/img/pokeball.gif")  # 등록된 이름 "car" 사용

    def drive(self):
        self.t1.forward(self.speed)

    def left_turn(self):
        self.t1.left(90)


# 자동차 객체 생성
myCar = Car(200, "red", "E-class")

# 자동차 이동
for i in range(100):
    myCar.drive()
    myCar.left_turn()

mainloop()



