from tkinter import N
import turtle as t

t.bgcolor("black")

t.speed(0)

def m(n, radius, col):
    for x in range(n):
        t.color(col)
        t.circle(radius)
        t.left(360/n)

m(70, 90, "blue")
m(50, 60, "green")
m(30, 30, "yellow")

t.exitonclick()