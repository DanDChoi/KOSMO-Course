#파일 쓰기
f = open("a.txt", "a", encoding="utf8") #추가
f.write("추가되는 문자열")
f.close()

f = open("b.txt", "w", encoding="utf8")
f.write("덮어쓴 문자열")
f.close()

#1 파일읽기/ 상대경로
f = open("a.txt", encoding="utf8")
#f = open("a.txt", "rt", encoding="utf8") "rt"는 디폴트값
print(f.read())
f.close()
print()

#2 파일읽기/ 절대경로
f = open("C:\\경로\\경로\\경로.java", "r")
print(f.read())
f.close()
print()

#3 파일읽기/ 일부만 읽기
f = open("C:\\경로\\경로\\경로.java", "r")
print(f.read(100))
f.close()

