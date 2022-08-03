print(bool("")) #false cause only empty string
print(bool("문자열"))
print()

print(bool(0)) #false cause only 0
print(bool(2))
print()

print(bool([])) #false cause only empty list
print(bool(["가","나"]))
print()

#Example which return 'False'
print(bool(False))
print(bool(None))
print(bool(0))
print(bool(""))
print(bool([]))
print(bool(()))
print(bool({}))
print()


def m1():
    return True

if m1():
    print("T")
else:
    print("F")
print()

#변수형을 확인하는 메소드 isinstance()
a = 10
print(isinstance(a, int))