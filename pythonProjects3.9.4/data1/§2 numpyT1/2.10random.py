import numpy as np

print("生成随机数组")
print(np.random.rand(2, 2))

print("生成随机数种子，传递给seed的参数相同，每次会生成相同的随机数")
np.random.seed(0)
print(np.random.rand(5))


