import turtle as t
  
#t.shape("square")
#t.shape("circle")
t.shape("turtle")
t.pensize(1)

def m(n, len, col): # 다각형을 그리는 메소드
    t.color(col)
    for x in range(n):
        t.forward(len)
        t.right(360/n)

t.begin_fill()
m(4, 50, "red")
t.end_fill()

m(5, 60, "green")
m(6, 70, "blue")

t.circle(80) # 반지름이 80

t.exitonclick()