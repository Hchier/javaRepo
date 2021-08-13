import pandas as pd
import numpy as np

data1 = pd.DataFrame(np.arange(0, 20).reshape(4, 5), columns=list('abcde'))
data1['key'] = pd.Series(list('aabc'))
print(data1)
# print(data1.groupby('key').mean())

print(dict(item for item in data1.groupby('key'))['a'])

print(data1.groupby('key').mean())
