import random
doors = {1,2,3}
stay_win = 0
switch_win = 0
trials = 1000000

for i in range(trials):
    car = random.randint(1,3)

    user_choice = random.randint(1,3)

    say_not_car = random.choice(list(doors - {user_choice, car}))

    # print("car:",car)
    # print("user_choice:",user_choice)
    # print("not_car:",not_car)
    # print("not_car:", say_not_car)
    # print("-------------------------")
    if car == user_choice:
        stay_win += 1
    else:
        switch_win += 1
stay_win_rate = stay_win / trials * 100
switch_win_rate = switch_win / trials * 100

print("stay_win: " + str(stay_win) + "\n" +
      "stay_win_rate: " + str(stay_win_rate)+"%")
print("switch_win: " + str(switch_win) + "\n" +
      "switch_win_rate: " + str(switch_win_rate)+"%")



