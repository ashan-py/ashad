class Car:
    def __init__(self, speed, color, model):
        self.speed = speed
        self.color = color
        self.model = model

    def drive(self):
        self.speed = 60
    def __str__(self):
        msg = "속도:" + str(self.speed) + " 색상:" + self.color + " 모델:" + self.model
        return msg


dadCar = Car(0, "silver", "A6")
momCar = Car(0, "white", "520d")
myCar = Car(0, "blue", "E-class")
print(dadCar)
print(momCar)
print(myCar)