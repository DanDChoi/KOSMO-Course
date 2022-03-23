import os

def myRemoveDir(target): # 구현하시오
    os.rmdir(target)

target = input("삭제할 디렉토리:")

if os.path.exists(target):
    if os.path.isdir(target):
        print(target+"은 존재하는 디렉토리")
        myRemoveDir(target)
        print("삭제완료")
    else:
        print(target+"은 디렉토리가 아님")
else:
    print(target+"이란 디렉토리는 존재하지 않음")