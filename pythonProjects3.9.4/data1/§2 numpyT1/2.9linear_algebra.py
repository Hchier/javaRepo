import numpy as np

arr1 = np.array([[1, 2, 3], [4, 5, 6]])
arr2 = np.array([[1, 2], [3, 4], [5, 6]])
print("2x3 3x2 矩阵相乘：")
print(np.dot(arr1, arr2))
print("以一维数组的方式返回方阵的对角线")
print(np.diag(np.dot(arr1, arr2)))

print(np.arange(4))
print("将一维数组转换成方阵")
print(np.diag(np.arange(4)))
print("计算对角线元素和")
print(np.trace(np.diag(np.arange(4))))
print("计算矩阵行列式")
print(np.linalg.det(np.diag(np.arange(4))))
print("计算特征值和特征向量")
print(np.linalg.eig(np.arange(16).reshape(4, 4)))
