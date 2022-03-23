# for 문은 Collection 과 친하다
from typing import Container


animals = ["tiger", "lion", "rabbit", "mouse"]

for x in animals:
    if x=="rabbit": continue #break
    print(x)
print()

'''  추천은 하지 않음 
i = 0
while i<len(animals):
    print(animals[i])
    i+=1
print()
'''

for c in "tiger":
    print(c)
print()

for i in range(5):
    print(i)
print()

for i in range(1, 5):
    print(i)
print()

for i in range(0, 5, 2):
    print(i, end=' ') #print(i, end='\n') == print(i) 
else:
    print("for end")
print()

a = ["a", "b", "c"]
b = ["A", "B", "C"]
for x in a:
    for y in b:
        print(x, y)
print()

for x in ['AA', 'BB', 'CC']:
    print(x)
print()

m = {"k1":"AAA", "k2":"BBB", "k3":"CCC"}
for k in m:
    print(k, m[k])
print()

for k, v in m.items():
    print(k, v)