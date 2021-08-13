import numpy as np

list1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
# print(help(np.ones))
# ndarray3 = np.arange(12).reshape(2, 2, 3)
# print(ndarray3)
# print(ndarray3[0][1][1])
# print(ndarray3.shape[2])
# print(ndarray3.ndim)
# # 所有元素个数
# print(ndarray3.size)
# # 元素的数据类型
# print(ndarray3.dtype)
# # 每个元素所占内存
# print(ndarray3.itemsize)

# ndarray4 = np.arange(20).reshape(4, 5)
# print(ndarray4)

# # 全一         # .zeros全l零
# ndarray5 = np.ones(10).reshape(2, 5)
# print(ndarray5)

# # 生成未赋值的
# ndarray5 = np.empty(5)
# print(ndarray5)

# # # 创建ndarray时指类型
# ndarray6 = np.ones(5, dtype=np.int64)
# print(ndarray6)
#
# # 转换类型 原来不变
# ndarray7 = ndarray6.astype(np.float64)
# print(ndarray7)


# # vector operation, 形状完全一样
# array1 = np.arange(20).reshape(5, 4)
# array2 = np.arange(20).reshape(5, 4)
# print(array1 + array2)

# # scalar
# # 每个都+1
# print(array1 + 1)

# # 数组广播
# # 维度相同，其中一个维度为1或列数相等，可以扩容（广播）
# array3 = np.arange(4).reshape(1, 4)
# array4 = np.arange(8).reshape(2, 4)
# print(array3 + array4)
# # 维度不同，将形状右对齐，共有维度满足上条则可
# array3 = np.arange(8).reshape(1, 8)
# array4 = np.arange(8).reshape(2, 4)


