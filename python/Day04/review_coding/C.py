import os

#os.remove("a.txt")

if os.path.exists("b.dump"):
    print("해당파일존재")
    os.remove("b.dump")
    print("해당파일삭제")
    