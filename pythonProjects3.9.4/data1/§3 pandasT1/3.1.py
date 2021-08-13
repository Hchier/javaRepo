import pandas as pd
import numpy as np

print("默认index数字")
pd1 = pd.Series(['a', 'b', 'c', 'd', 'e', 'f'])
print(pd1)
print()

print("自定义index")
pd2 = pd.Series([1, 2, 3, 4], index=['a', 'b', 'c', 'd'])
print(pd1)
print()

print("字典")
dict1 = {2000: 0, 2001: 1, 2002: 2, 2003: 3}
pd3 = pd.Series(dict1)
print(pd3)
print()

print("DataFrame")
arr1 = np.array([['a', 'b', 'c'], ['d', 'e', 'f']])
df1 = pd.DataFrame(arr1)
print(df1)
print(df1[0][1])
print("新增列")
df1[3] = ['g', 'h']
print(df1)
print("删除列")
del df1[3]
print(df1)
print()

