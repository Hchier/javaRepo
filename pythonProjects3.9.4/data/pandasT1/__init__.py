import pandas as pd
import numpy as np

# series对象，一个一维数据结构 + 1个索引
series1 = pd.Series([6, 5, 4, 3, 2, 1])
print(series1)

# DataFrame,二维数据结构，一个行索引(index) + 一个列索引（column）
dataframe1 = pd.DataFrame(np.arange(20).reshape(4, 5), columns=['a', 'b', 'c', 'd', 'e'], index=[1, 2, 3, 4])
print(dataframe1)
print(dataframe1['a'][1])
print(dataframe1.index)
print(dataframe1.columns)
