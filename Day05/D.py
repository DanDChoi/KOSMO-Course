import turtle as t
import random as r

t.shape("turtle")
t.speed(0)

t.bgcolor("black")
colors = ["yellow", "green", "blue", "red"]

for x in range(200):
    c = r.choice(colors)
    t.color(c)
    a = r.randint(1, 360)
    t.setheading(a)
    d = r.randint(1, 30)
    t.forward(d)

t.exitonclick()