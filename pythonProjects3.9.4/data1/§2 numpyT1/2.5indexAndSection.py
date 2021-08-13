import numpy as np

print("numpy的索引和切片")
data1 = np.arange(8)
# 获取[2，6),步长为2
print(data1[2:6:2])
print(data1[:6])

data2 = np.arange(60).reshape(5, 4, 3)
print(data2)
print(data2[:3, :2, :1])
print(data2[3, 2, 1])
print()

print("花式索引")
data1 = np.empty((4, 4))
for i in range(0, 4):
    data1[i] = np.arange(i, i + 4)
print(data1)
# 获取（0，1）（3，1）
print(data1[[0, 3], [1, 1]])
print()

print("布尔索引")
name = np.array(['a', 'b', 'c', 'd'])
score = np.array([[1], [2], [3], [4]])
print(score[name == 'c'])
print()
