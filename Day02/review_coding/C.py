a = 1
b = 2.5
c = 3j
print(type(a))
print(type(b))
print(type(c))
print()

a1 = int(a)
a2 = int(b)
a3 = int("3")
#a4 = int(c) impossible
print(a1)
print(a2)
print(a3+1)
print()

b1 = float(a)
b2 = float(b)
b3 = float("3")
print(b1)
print(b2)
print(b3)
print()

c1 = str("가")
c2 = str(a)
c3 = str(b+1)
print(c1)
print(c2+"문자열")
print(c3+"문자열")
print()