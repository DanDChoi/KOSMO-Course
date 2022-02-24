import os

def myRemoveDir(dir):
    kids = os.listdir(dir)
    for kid in kids:
        kid_full_path = os.path.join(dir, kid)
        if os.path.isfile(kid_full_path):
            os.remove(kid_full_path)
        else:
            kidskids = os.listdir(kid_full_path)
            if len(kidskids) == 0:
                os.rmdir(kid_full_path)
            else:
                myRemoveDir(kid_full_path)
    os.rmdir(dir)
    
target = input("삭제할 디렉토리:")

if os.path.exists(target):
    if os.path.isdir(target):
        myRemoveDir(target)
    else:
        print(target +"은 디렉토리가 아님")
else:
    print(target + "이란 디렉토리는 존재하지 않음")