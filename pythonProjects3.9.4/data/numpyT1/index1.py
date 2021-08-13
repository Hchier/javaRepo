import numpy as np

# # n维数组基本索引
# a1 = np.arange(16).reshape(2, 4, 2)
# print(a1)
# print(a1[1, 3])
# print(a1[1, 3, 1])
# print(a1[1, :, :])


# # 花式索引 ndarray[第一个维度的序号数组，。。第n个维度的序号数组]
# a2 = np.arange(30).reshape(5, 6)
# print(a2)
# # 找[1, 0] & [2, 2]
# print(a2[[1, 2], [0, 2]])
# print()
# print(a2[[0, 0, 4, 4], [0, 5, 0, 5]])
# print(a2[[[0, 0], [4, 4]], [[0, 5], [0, 5]]])


# # 布尔索引:拿一个相同形状的布尔array0跟array1进行索引，筛选出布尔数组对应的true的位置
# a3 = np.arange(30).reshape(5, 6)
# bool1_a3 = a3 > 10
# bool2_a3 = a3 < 3
# print(bool1_a3 | bool2_a3)
# print(a3[bool1_a3 | bool2_a3])


# 轴（axes）定义，数组的维度


# # 通用函数
# # 一元函数，np.函数名(a1)
# # 二元函数, np.函数名(a1, a2)
# a5 = np.array([1.6, 5.4, 5.2])
# a6 = np.array([3.2, 1.4, 2.9])
# # 向上取整
# print(np.ceil(a5))
# # 向下取整
# print(np.floor(a5).astype(np.int64))
# # 两个相乘
# print(np.multiply(a5, a6))
# # a5 > a6 的
# print(np.greater(a5, a6))
# # 把a5中 > 4 的置为0，否，则不动
# print(np.where(a5 > 4, 0, a5))


# # any all
# a6 = np.arange(20).reshape(4, 5)
# # any（bool数组），数组中一个为true， 返回true
# # all（bool数组），有一个为false，则为false
# print(np.any(a6 > 10))


# # sort
# a7 = np.array([[2, 3, 4], [1, 8, 2], [1, 4, 7]])
#
# print(a7)
