#디렉토리 리스팅

import os

'''
dir = "파일경로"
kids = os.listdir(dir)
for kid in kids:
    if os.path.isfile(dir + "/" + kid):
        print("[F] ", kid)
    else:
        print("[D] ", kid)
'''

def myListDir(dir):
    kids = os.listdir(dir)
    for kid in kids:
        if os.path.isfile(dir + "/" + kid):
            print("[F] ", kid)
        else:
            print("[D] ", kid)

target = input("리스팅할 디렉토리:")

if os.path.exists(target):
    if os.path.isdir(target):
       myListDir(target)
    else:
        print(target + "은 디렉토리가 아님")
else:
    print(target + "이라는 디렉토리는 존재하지 않음") 
