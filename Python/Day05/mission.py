import turtle as t

t.bgcolor("yellow")

t.shape("turtle") # 주인공
t.color("white")

te = t.Turtle() #적
te.shape("turtle")
te.color("red")
angle = te.towards(t.pos())
te.sethading(angle)

tf = t.Turtle() #먹이
tf.shape("circle")
tf.color("green")



def r():
    t.setheading(0)
    t.forward(10)
def u():
    t.setheading(90)
    t.forward(10)
def l():
    t.setheading(180)
    t.forward(10)
def d():
    t.setheading(270)
    t.forward(10)

t.onkeypress(r, "Right")
t.onkeypress(u, "Up")
t.onkeypress(l, "Left")
t.onkeypress(d, "Down")

t.listen()
t.mainloop()