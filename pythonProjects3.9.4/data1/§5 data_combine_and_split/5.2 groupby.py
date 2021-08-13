import pandas as pd
import numpy as np

data1 = pd.DataFrame({'key': ['a', 'b', 'a', 'b'], 'value': ['1', '2', '3', '4']})
print(data1)
for item in data1.groupby('key'):
    print(item)
print()

data2 = pd.DataFrame(np.arange(0, 12).reshape(3, 4), columns=['a', 'b', 'c', 'd'])
print(data2)
print("通过字典")
mapping = {'a': '一', 'b': '二', 'c': '一', 'd': '三'}
for item in data2.groupby(mapping, axis=1):
    print(item)
