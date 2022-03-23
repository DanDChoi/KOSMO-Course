#dict (중복(ket X, value O), 순서보존 X)

#1 데이터추출
a = {"name":"홍길동", "age":24}
print(a)
print(a["name"])
print(a["age"])
print()

#2 element 핸들링
#2-1 변경 (change)
a["name"] = "이순신"
a["age"] = 30
print(a)
print()

# 2-2 추가 (append + insert)
a["addr"] = "서울시"
print(a)
print()

#2-3-1 삭제1 (del) : key값
del a["name"]
print(a)
print()

#2-3-2 삭제2 (pop) : key값
a.pop("age")
print(a)
print()

#2-3-3 삭제3 (popitem) : 마지막으로 추가된 아이템 삭제
a = {"name":"홍길동", "age":24}
a.popitem()
print(a)
print()

#2-3-4 삭제4 (clear) : 모든 elements
a = {"name":"홍길동", "age":24}
a.clear();
print(a)
print()

#3 핸들링
#3-1(loop)
b = {"an1":"tiger", "an2":"lion", "an3":"rabbit"}
for k in b:
    print("key: ", k , " value: ", b[k])
print()

for v in b.values():
    print(v)
print()

for k, v in b.items():
    print(k, v)
print()

#3-2 핸들링 (if)
if "an2" in b:
    print("an2라는 key값이 존재")
print()

if "lion" in b.values():
    print("lion이라는 value값이 존재")
print()

#3-3 핸들링 (len)
print(len(b))
print()

#3-4 복사
bb = b.copy()
print(bb)
if bb is b:
    print("same object")
else:
    print("different object")
print()

#4 합치기 불가

#5 Nested Dict
students = {"name":"강감찬", "age":27}
students = {
    "st1": students,
    "st2": {"name":"유관순", "age":20}
}
print(students)