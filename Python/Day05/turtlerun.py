import turtle as t
import random

score = 0
playing = False

t.title("거북이 잡기")  # 주인공
t.setup(500, 500)
t.bgcolor("orange")
t.shape("turtle")
t.speed(9)
t.up()
t.color("white")

te = t.Turtle()  # 악당
te.shape("turtle")
te.color("red")
te.speed(9)
te.up()
te.goto(0, 200)

tf = t.Turtle()  # 먹이
tf.shape("circle")
tf.color("green")
tf.speed(9)
tf.up()
tf.goto(0, -200)


def message(m1, m2):
    t.clear()
    t.goto(0, 100)
    t.write(m1, False, "center", ("", 20))
    t.goto(0, -100)
    t.write(m2, False, "center", ("", 15))
    t.home()


message("거북이 잡기!!", "[Space]를 누르면 시작합니다")


def r():
    t.setheading(0)


def u():
    t.setheading(90)


def l():
    t.setheading(180)


def d():
    t.setheading(270)


def start():
    global playing
    if playing == False:
        playing = True
        t.clear()
        play()


def play():
    global score
    global playing
    t.forward(10)
    if random.randint(1, 5) == 3:
        ang = te.towards(t.pos())
        te.setheading(ang)
    speed = score + 5

    if speed > 15:
        speed = 15
    te.forward(speed)

    if t.distance(te) < 12:
        text = "Score: " + str(score)
        message("Game Over", text)
        playing = False
        score = 0
        te.goto(0, 200)
        t.goto(0, 0)
    if t.distance(tf) < 12:
        score = score + 1
        t.write(score)
        star_x = random.randint(-230, 230)
        star_y = random.randint(-230, 230)
        tf.goto(star_x, star_y)

    if playing:
        t.ontimer(play, 100)


t.onkeypress(r, "Right")
t.onkeypress(u, "Up")
t.onkeypress(l, "Left")
t.onkeypress(d, "Down")
t.onkeypress(start, "space")

t.listen()
t.mainloop()
