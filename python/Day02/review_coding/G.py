#set (중복허용X, 순서보존X)

#1 데이터 추출
a = {"a", "b", "c", "a"}
print(a)
#print(a[1:3]) 불가, index 가 없음
print()

#2 element 핸들링
#2-1 변경 (change)
#a[1] = "bb" 불가, index가 없음

#2-2 추가1(add)
a.add("g")
print(a)
print()

#2-3 추가2 (update)
a.update({"lion", "rabbit"})
print(a)
print()

#2-4 삽입 (insert)
#a.insert(3, "cc") 불가 index가 없음

#2-5-1 삭제1 (remove) : 내용
#a.remove("c")
a.discard("c")
print(a)
print()

#2-5-2 삭제2 (del) : 인덱스 불가, index가 없음

#2-5-3 삭제3 (pop): 랜덤한 element가 삭제
a.pop()
print(a)
print()

#2-5-4 삭제4 (clear) : 모두 삭제
a.clear()
print(len(a))
print()

#3 핸들링
#3-1 핸들링 (loop)
b = {"tiger", "lion", "rabbit"}
for x in b:
    print(x)
    
#3-2 핸들링 (if)
if "lion" in b:
    print("사자 있음")
    
#3-3 핸들링 (len)
print(len(b))
print()

#3-4 복사
bb = b.copy
print(bb)
if bb is b:
    print("same object")
else:
    print("diffent object")
print()

#4 합치기
#4-1 방법1
c1 = {"a", "b", "c"}
c2 = {10, 20, 30}
# c = c1 + c2 불가
c = c1.union(c2)
print("c: ", c)
print()

#4-2 방법2
for x in c2:
    c1.add(x)
print("c1: ", c1)
print()

#4-3 방법3
c1 = {"a", "b", "c"}
#c1.extend(c2) 불가!
