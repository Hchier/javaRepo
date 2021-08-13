import pandas as pd
import numpy as np

# 层次化索引
tuple1 = [('四川', '成都', '新都'), ('湖北', '宜昌', '宜都')]
num1 = [10, 11]
num2 = [123, 456]
dict1 = {'num1': num1, 'num2': num2}
mutil_index1 = pd.MultiIndex.from_tuples(tuple1)
num1_series = pd.Series(num1, index=mutil_index1)
df2 = pd.DataFrame(dict1, index=mutil_index1)
print(mutil_index1)
print(num1_series)
print(df2)
