#Iterator
a = ["tiger", "lion", "rabbit", "deer"]

it = iter(a)
print(next(it))

#방법1
'''
i = 0
while(i<len(a)):
    print(next(it))
    i+=1
'''

#방법2
for x in it:
    print(x)