#상속(Inheritance)

class Human:
    def __init__(self, name):
        self.name = name
    def move(self):
        print("걷는다")

h = Human("길동")
print("h.name:", h.name)
h.move()
print()

class Superman(Human):
    def __init__(self, name, power):
        super().__init__(name)
        self.power = power
        
    def move(self):
        print("난다")
    def shotBeam(self):
        print("광선을 쏜다")
        
s = Superman("클락", 100)
print("s.name:", s.name)
print("s.power:", s.power)
s.move()
s.shotBeam()
