# function 
def m1():
    print("이것이 펑션")
m1(); m1()
print()

def m2(name, age):
    print("name:", name , " age:", age)
m2("길동", 30); m2("순신", 40)
print()


def m3(*args):
    #print(args[2])
    for x in args:
        print(x)
m3("짜장1", "짬뽕1")
print()
m3("짜장2", "짬뽕2", 2000)
print()


def m4(**args):
    print(args["name"], args["age"], args["addr"])
m4(name="홍길동", age=20, addr="서울")
print()

def m5(args1, args2, args3):
    print("args1:", args1, "args2:", args2, "args3:", args3)
m5(args3="가", args1="나", args2="다")
print()

def m6(arg="바보"):
    print("arg:", arg)
m6("천재")
m6()
print()

def m7(animals):
    for x in animals:
        print(x)
animals = ["tiger", "lion", "rabbit", "mouse"]
m7(animals)
print()

def m8(a, b):
    return a+b
result = m8(10, 20)
print(result)
print()

def m9():
    pass
m9()    
print("end");
