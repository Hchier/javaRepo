import numpy as np

list1 = np.ones(64).reshape(8, 8)
print(list1)
print()
for i in range(0, 8):
    for j in range(0, 8):
        if (i + j) % 2 == 1:
            list1[i][j] = 0
print(list1)
