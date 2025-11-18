def change ():
    global user_choice, say_not_car, second_user_choice, user_change
    user_change = input("You wanna change?(yes/no): ")
    if user_change == "yes":
        second_user_choice = list(doors - {first_user_choice, say_not_car})[0]
    elif user_change == "no":
        second_user_choice = first_user_choice
    else:
        print("say yes or no")
        change()












import random

doors = {1,2,3}
stay_win = 0
switch_win = 0
trials = 10

for i in range(trials):
    print(i+1)
    car = random.randint(1,3)

    first_user_choice = int(input('choice num(1~3): '))

    say_not_car = random.choice(list(doors - {first_user_choice, car}))

    print("The door without the car: " + str(say_not_car))


    change()

    if second_user_choice == car:
        ch = "correct"
        if user_change == "yes":
            switch_win += 1
        else:
            stay_win += 1
    else:
        ch = "incorrect"

    print("-------------------------")
    print("car:", car)
    print("first_user_choice:", first_user_choice)
    print("say_not_car:", say_not_car)
    print("user_change:", user_change)
    print("second_user_choice:", second_user_choice)
    print("ch:", ch)
    print("-------------------------")


stay_win_rate = stay_win / trials * 100
switch_win_rate = switch_win / trials * 100

print("stay_win: " + str(stay_win) + "\n" +
      "stay_win_rate: " + str(stay_win_rate)+"%")
print("switch_win: " + str(switch_win) + "\n" +
      "switch_win_rate: " + str(switch_win_rate)+"%")

