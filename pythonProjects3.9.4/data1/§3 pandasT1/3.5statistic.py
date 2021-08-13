import pandas as pd
import numpy as np

pd1 = pd.DataFrame(np.arange(12).reshape(3, 4), columns=['a', 'b', 'c', 'd'])
print(pd1)
print()
print("行的和")
print(pd1.sum(axis=1))
print("列的累计和")
print(pd1.cumsum())

print("统计描述")
pd2 = pd.DataFrame(np.arange(12).reshape(3, 4), columns=['a', 'b', 'c', 'd'])
print(pd2)
print(pd2.describe())
