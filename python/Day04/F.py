# 디렉토리 리스팅 
import os

dir = "C:\\SOO\\Python\\day04"
kids = os.listdir(dir)
#print("kids:", kids)
for kid in kids:
    if os.path.isfile(dir + "\\" + kid):
        print("[F] ", kid)
    else:
        print("[D] ", kid)
        
target = input("리스팅할 디렉토리:")
