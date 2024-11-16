# tkinter을 사용해 가위바위보 게임을 생성

from tkinter import*
import random
window = Tk()

def comp(user):
    l7["text"]=user
    cl = ["가위", "바위", "보"]
    comnum = random.randint(0,2)
    com = cl[comnum]
    l3["text"] = (com)
    if com == user:
        l5["text"] = ("비겼다")
    elif com == "가위":
        if user == "바위":
            l5["text"]=("이겼다")
        else:
            l5["text"] = ("졌다")
    elif com == "바위":
        if user == "보":
            l5["text"] = ("이겼다")
        else:
            l5["text"] = ("졌다")
    elif com == "보":
        if user == "가위":
            l5["text"] = ("이겼다")
        else:
            l5["text"] = ("졌다")
def comp1():
    comp("가위")
def comp2():
    comp("바위")
def comp3():
    comp("보")


l1 = Label(window,text="가위 바위 보!")
l2 = Label(window, text="컴퓨터 :")
l3 = Label(window, text="")
l6 = Label(window, text="사용자 :")
l7 = Label(window, text="")
l4 = Label(window, text="결과 :")
l5 = Label(window, text="")
l1.grid(row=0, column=1)
l2.grid(row=1, column=0)
l3.grid(row=1, column=1)
l6.grid(row=2, column=0)
l7.grid(row=2, column=1)
l4.grid(row=3, column=0)
l5.grid(row=3, column=1)
#


b1 = Button(window, text="가위", command=comp1)
b2 = Button(window, text="바위", command=comp2)
b3 = Button(window, text="보", command=comp3)
b1.grid(row=4, column=0)
b2.grid(row=4, column=1)
b3.grid(row=4, column=2)

window.mainloop()