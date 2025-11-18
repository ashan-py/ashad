import random
import turtle
a=random.randint(0,9) # 원래의 a 값은 0,9사이 랜덤 값을 가짐 고로 구간을 가져야하는 문제의 의도와 다름
# a가 구간 값을 가지도록 수정
if 0<= a <=3:
    a = 1
elif 4<= a <=6:
    a = 2
else:
    a = 3
#위의 if문을 통해서 a가 구간 값을 가짐
print("난수 1구간:0~3 2구간:4~6 3구간:7~9입니다.")
print(a)
one=int(input("3구간중 하나의 구간을 숫자로 입력하시오:")) #사용자에게 구간 값을 받을 수 있게 됌
t=turtle.Turtle()

if one == a: #결국 One과 a가 같냐를 판단하는 식이기 때문에 간소화 가능
    t.fillcolor("blue")
    t.begin_fill()
    t.circle(50)
    t.end_fill()
    t.penup()
    t.left(90)
    t.forward(100)
    t.right(90)
    t.pendown()#원의 반지름을 50으로 잡았기 때문에 펜업을 한 상태로 100만큼 위로 가주면 됌
#     원래 보다 나은 이유는 원래 만들었던 코드에서는 1이 틀렸을 경우에도 2에서는 무조건 goto0,100에서 시작하는데
#     이렇게 할 경우에는 1번이 틀리면 2번째는 0,0에서 시작
else:
    print("첫번째 원 그리기 실패")
b=random.randint(0,9)
print(b)
two=int(input("3구간중 하나의 구간을 숫자로 입력하시오:"))

if two == b:
    t.fillcolor("blue")
    t.begin_fill()
    t.circle(50)
    t.end_fill()
else:
    print("두번째 원 그리기 실패")
c=random.randint(0,9)
print(c)
thr=int(input("3구간중 하나의 구간을 숫자로 입력하시오:"))

if ((0<=c<=3) and thr==1) or ((4<=c<=6) and thr==2) or ((7<=c<=9) and thr==3):
    t.penup()
    t.goto(0,200)
    t.pendown()
    t.fillcolor("blue")
    t.begin_fill()
    t.circle(50)
    t.end_fill()
else:
    print("세번째 원 그리기 실패")