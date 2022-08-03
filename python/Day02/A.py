#변수의 선언 
a = 10
print(a)
b = '스트링'
print(b)
print()

a, b, c = "짜장", "짬뽕", "탕수육"
print(a)
print(b)
print(c)
print()

d=e=f="마라탕"
print(d)
print(e)
print(f)
print()

g1 = "파이썬은 "
g2 = "심플해!"
print(g1+g2)
print()

h = "member variable"
def m1():
    #h="local variable"
    #print(h)
    
    global h
    print(h)
    h = "이건 뭐라 출력될까?"
    print(h)
    
m1()
#print(h)