import os

#os.remove("a.txt")

if os.path.exists("b.dump"):
    print("해당 파일 존재")
    os.remove("b.dump")
    print("해당 파일 삭제")
