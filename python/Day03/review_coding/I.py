# Scope : global (전역변수로 승격)
def m1(): #Outter function
    global a
    a = 1
    def m2(): #Inner function
        global b
        b = 2
        print("a:", a, "b:", b)
    m2()
    
m1()
print("a:", a)
print("b:", b)