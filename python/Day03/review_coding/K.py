#Exception

#1 예외 처리
try:
    f = open("myfile.txt")
    s = f.readline()
    i = int(s.strip())
    print(i)
except OSError as ose:
    print("OSError발생 ose:", ose)
except ValueError:
    print("숫자가 아님")
except:
    print("이외의 예외")
finally:
    print("항상 수행되는 절")

#2 예외 발생
flag = True
def m1():
    if flag:
        raise Exception("Soo's Exception")
    
try:
    m1()
    print("예외발생안함")
except:
    print("예외발생함")