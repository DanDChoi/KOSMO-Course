fname = "original.txt"
f = open(fname, "r")

s = set()
while True:
    line = f.readline()
    if not line: break
    line = line.strip()
    s.add(line)
f.close()

li = []
for x in s:
    li.append(x)
    
import random
q = random.choice(li)

print("[타자게임!! 준비되면 엔터!!]")
input()

import time
start = time.time()

end = time.time()

print("걸린시간", end-start)