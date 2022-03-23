a = 1
print(type(a))
print()

b = 0.12
print(type(b))
print()

c = "문자열"
print(type(c))
print()

d = ["가", "나", "다"]
print(type(d))
print()

e = ("가", "나", "다")
print(type(e))
print()

f1 = {"가", "나", "다"}
print(type(f1))
print()

f2 = frozenset({"가", "나", "다"})
print(type(f2))
print()

g = {"name":"길동", "age":24}
print(type(g))
print()

h = range(4)
print(type(h))
print()

for i in h:
    print(i)
    
i = False
print(type(i))