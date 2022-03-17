# list ( 중복허용O 순서보존O  )

# (1) 데이터 추출 
a = ["a", "b", "c", "d", "e", "f", "a"]
print(a)
print(a[-2])
print(a[1:3]) #이상 미만 
print(a[3:]) #이상
print(a[:3]) #미만
print(a[-3:-1]) #이상 미만 
print()

# (2) Elements 핸들링 
# 2-1 변경 ( change )
a[1] = "bb"
print(a)
print()

# 2-2 추가 ( append )
a.append("g")
print(a)
print()

# 2-3 삽입 ( insert )
a.insert(3, "cc")
print(a)
print()

# 2-4-1 삭제1 ( remove ) : 내용 
a.remove("cc")
print(a)
print()

# 2-4-2 삭제2 ( del ) : 인덱스 
del a[1]
print(a)
print()

# 2-4-3 삭제3 ( pop ) : 맨끝에 있는 녀석 
a.pop()
print(a)
print()

# 2-4-4 삭제4 ( clear ) : 모두
a.clear()
print(a)
print()

# (3) 핸들링 
# 3-1 핸들링 ( loop )
b = ["tiger", "lion", "rabbit"]
for x in b:
    print(x)
    
# 3-2 핸들링 ( if )
if "lion" in b:
    print("사자 있음")
    
# 3-3 핸들링 ( len )
print(len(b))
print()

# 3-4 복사
bb = b.copy()
print(bb)
if bb is b:
    print("같은 객체")
else:
    print("다른 객체")
print()

# (4) 합치기
# 4-1 방법1
c1 = ["a", "b", "c"]
c2 = [10, 20, 30]
c = c1 + c2
print("c: ", c)
print()

# 4-2 방법2
for x in c2:
    c1.append(x)
print("c1:", c1)
print()

# 4-3 방법3
c1 = ["a", "b", "c"]
c1.extend(c2)
print("c1:", c1)
print()
