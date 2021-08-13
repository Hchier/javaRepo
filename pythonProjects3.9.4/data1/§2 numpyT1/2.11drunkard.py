import numpy as np

list1 = []
for i in range(0, 1000):
    random_num = np.random.rand()
    list1.append(1) if random_num >= 0.5 else list1.append(-1)
list1_np = np.array(list1)
list1_np
# 最远到过的距离
print(np.max(np.cumsum(list1_np)))
