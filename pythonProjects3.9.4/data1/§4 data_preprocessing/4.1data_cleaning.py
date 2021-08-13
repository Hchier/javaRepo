import pandas as pd
import numpy as np

print("空值处理")
data1 = pd.Series([1, None, np.NaN])
print(pd.notnull(data1))
print()

print("dropna()删除具有空置的行或列")
data2 = pd.DataFrame(np.arange(0, 12).reshape(3, 4))
print(data2)
print()
data2[1][1] = None
data2 = data2.dropna()
print(data2)
print()

print("填充空值")
data2 = pd.Series([1, None, np.NaN])
print("根据索引指定填充的位置，不指定则全部都填")
print(data1.fillna({1: 0}))
print()

print("重复值的处理")
print("drop_duplicated()")
data3 = pd.Series([1, 1, 2, 2, 3])
data3 = data3.duplicated()
print(data3)
print()

print("异常值的处理")
print()
