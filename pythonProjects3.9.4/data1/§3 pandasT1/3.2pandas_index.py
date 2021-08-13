import pandas as pd
import numpy as np

print("重置index")
df1 = pd.Series([1, 2, 3], index=['a', 'b', 'c'])
print(df1)
print(df1.reindex(['a', 'c', 'b', 'e'], method='ffill'))
print()

print("Series索引操作")
data1 = pd.Series([1, 2, 3, 4], index=['a', 'b', 'c', 'd'])
print(data1)
print("通过索引名称")
print(data1['c'])
print("通过索引位置")
print(data1[1])

print("通过名称切片：全闭区间。通过位置切片：半开半闭")
print("通过索引名称切片")
print(data1['b':'d'])
print("通过索引位置切片")
print(data1[1:3])
print()

print("DataFrame索引操作")
df1 = pd.DataFrame(np.arange(12).reshape(3, 4), columns=['a', 'b', 'c', 'd'])
print(df1)
print("获取不连续的列")
print(df1[['b', 'd']])
print("通过切片获取多行")
print(df1[:2])
print("")
print(df1[['b', 'd']][:2])
print()
