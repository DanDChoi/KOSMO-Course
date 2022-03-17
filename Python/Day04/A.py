# 파일 생성 & 권한 
'''
   "r": Read
   "a": Append 
   "w": Write
   "x": Create 
   
   "t": Text
   "b": Binary 
'''
f1 = open("a.txt", "xt")
f2 = open("b.dump", "xb")
print("파일생성완료")