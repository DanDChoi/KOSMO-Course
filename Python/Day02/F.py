# tuple ( 중복허용O 순서보존O unchangeable )

# (1) 데이터 추출 
a = ("a", "b", "c", "d", "e", "f", "a")
print(a)
print(a[-2])
print(a[1:3]) #이상 미만 
print(a[3:]) #이상
print(a[:3]) #미만
print(a[-3:-1]) #이상 미만 
print()

# (2) Elements 핸들링 
# 2-1 변경 ( change )
#a[1] = "bb" # 불가 why? 그게 튜플이야!
b = list(a) 
b[1] = "bb"
a = tuple(b) 
print(a)
print()

# 2-2 추가 삽입 제거~ ( append insert remove del pop clear ) : 불가!! why? 그게 튜플이야!
'''
a.append("g")
a.insert(3, "cc")
a.remove("cc")
del a[1]
a.pop()
a.clear()
'''

# (3) 핸들링
# 3-1 핸들링 ( loop )
b = ("tiger", "lion", "rabbit")
for x in b:
    print(x)
    
# 3-2 핸들링 ( if )
if "lion" in b:
    print("사자 있음")
    
# 3-3 핸들링 ( len )
print(len(b))
print()

# 3-4 복사
#bb = b.copy() #불가!! why? 그게 튜플이야!
#print(bb) 

# (4) 합치기
# 4-1 방법1
c1 = ("a", "b", "c")
c2 = (10, 20, 30)
c = c1 + c2
print("c: ", c)
print()

# 4-2 방법2 : #불가!! why? 그게 튜플이야!
#for x in c2:
#    c1.append(x)
#print("c1:", c1)
#print()

# 4-3 방법3 : #불가!! why? 그게 튜플이야!
#c1 = ("a", "b", "c")
#c1.extend(c2)
#print("c1:", c1)
#print()

# (5) element가 1개인 튜플 
d = ("apple",)
print(type(d))