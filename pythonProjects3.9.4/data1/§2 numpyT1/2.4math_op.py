import numpy as np

print("basic op")
data1 = np.arange(8).reshape(2, 2, 2)
data2 = np.arange(8).reshape(2, 2, 2)
print(data1 * data2)
print()

print("广播")
# arr1 = np.ones((2, 2, 2))
# arr2 = np.ones((2, 2))
# print(arr1)
# print(arr2)
# print(arr1 + arr2)

# 最后两个形状（3，2）要相等
arr1 = np.arange(24).reshape(4, 3, 2)
arr2 = np.ones((3, 2))
print(arr1)
print(arr2)
print(arr1 + arr2)
print()

print("数组与标量间的计算")
data1 = np.arange(8).reshape(2, 2, 2)
data2 = 5
print(data1 + data2)
print()








