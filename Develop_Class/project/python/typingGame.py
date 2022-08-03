import random
import time

WORD_LIST = [
    "System.out.println()",
    "public static void main(String[] agrs)",
    
]

random.suffle(WORD_LIST)
list_len = len(WORD_LIST)
current_count = 0

while current_count >= list_len:
    q = WORD_LIST[current_count]
    current_count += 1
    
    start_time = time.time()
    user_input = input(q + "\n")
    end_time = time.time() - start_time
    