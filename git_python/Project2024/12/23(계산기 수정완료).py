
from tkinter import *
window = Tk()

def acco():
    e1.delete(0,"end")
    l1["text"] = ""

def pmco():
    col = int(e1.get())
    pm = -1 * col
    e1.delete(0,"end")
    e1.insert(0,pm)

def percentco():
    col = float(e1.get())
    e1.delete(0,"end")
    per = float(col/100)
    if per.is_integer():
        per = int(per)
    e1.insert(0,per)


def solutionco():
    col = (e1.get())
    l1["text"] = col
    e1.delete(0,"end")
    sol = float(eval(col))
    if sol.is_integer():
        sol = int(sol)
    e1.insert(0,sol)

l1 = Label(window, text="", anchor="e",width=20,font=("nomal",10))
l1.grid(row = 0, column=0,columnspan=4)

e1 = Entry(window,justify='right',font=("nomal",12,"bold"))
e1.grid(row=1, column=0,columnspan=4)

ac = Button(window, text="AC", command=acco)
ac.grid(row=2, column=0)

pm = Button(window,text="+/-", command=pmco)
pm.grid(row=2, column=1)

percent = Button(window, text="%", command=percentco)
percent.grid(row=2,column=2)

division = Button(window, text="÷", command=lambda: e1.insert("end","/"))
division.grid(row=2,column=3)

multiplication = Button(window, text="x", command=lambda : e1.insert("end","*"))
multiplication.grid(row = 3, column=3)

minus = Button(window, text="-", command=lambda :e1.insert("end","-"))
minus.grid(row = 4, column=3)

plus = Button(window,text="+", command=lambda :e1.insert("end","+"))
plus.grid(row = 5, column=3)

solution = Button(window, text="=", command=solutionco)
solution.grid(row = 6, column = 3)

seven = Button(window,text="7", command=lambda: e1.insert("end",7))
seven.grid(row=3, column=0)

eight = Button(window,text="8", command=lambda:e1.insert("end",8))
eight.grid(row=3, column=1)

nine = Button(window,text="9", command=lambda:e1.insert("end",9))
nine.grid(row=3, column=2)

four = Button(window,text="4", command=lambda:e1.insert("end",4))
four.grid(row=4, column=0)

five = Button(window,text="5", command=lambda:e1.insert("end",5))
five.grid(row=4, column=1)

six = Button(window,text="6", command=lambda:e1.insert("end",6))
six.grid(row=4, column=2)

one = Button(window,text="1", command=lambda:e1.insert("end",1))
one.grid(row=5, column=0)

two = Button(window,text="2", command=lambda:e1.insert("end",2))
two.grid(row=5, column=1)

three = Button(window,text="3", command=lambda:e1.insert("end",3))
three.grid(row=5, column=2)

zz = Button(window,text="00", command=lambda:e1.insert("end","00"))
zz.grid(row=6, column=0)

zero = Button(window,text="0", command=lambda:e1.insert("end",0))
zero.grid(row=6, column=1)

dot = Button(window,text=".", command=lambda:e1.insert("end","."))
dot.grid(row=6, column=2)

window.mainloop()














